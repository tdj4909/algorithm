import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] trees;
    static int treeSum;
    static boolean loop;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0){
                break;
            }
            treeSum = 0;

            // 그래프 입력
            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++){
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                graph.get(v1).add(v2);
                graph.get(v2).add(v1);
            }
            trees = new int[n+1];
            trees[0] = -1;

            for (int i = 1; i <= n; i++){
                if (trees[i] != 0){
                    continue;
                }
                loop = false;
                trees[i] = ++treeSum;
                dfs(i, i);
                if (loop){
                    for (int j = 1; j <= n; j++){
                        if (trees[j] == treeSum){
                            trees[j] = -1;
                        }
                    }
                    treeSum--;
                }
            }

            if (treeSum == 0){
                System.out.printf("Case %d: No trees.\n", idx);
            } else if (treeSum == 1) {
                System.out.printf("Case %d: There is one tree.\n", idx);
            } else if (treeSum > 1){
                System.out.printf("Case %d: A forest of %d trees.\n", idx, treeSum);
            }
            idx++;
        }
    }
    public static void dfs(int prior, int curr){
        for (int next : graph.get(curr)){
            if (trees[next] == treeSum && next != prior){
                loop = true;
            } else if (trees[next] == 0){
                trees[next] = treeSum;
                dfs(curr, next);
            }
        }
    }
}