import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] distance;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            distance = new int[N+1];
            graph = new ArrayList<>();
            while (N-- >= 0){
                graph.add(new ArrayList<>());
            }


            while (M-- > 0){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            cnt = 0;
            dfs(1);
            System.out.println(cnt-2);
        }
    }

    public static void dfs(int start){
        distance[start] = cnt++;
        for (int next : graph.get(start)){
            if (distance[next] == 0){
                dfs(next);
            }
        }
    }
}