import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static int[] depth;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        depth = new int[n+1];
        Arrays.fill(depth, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }

        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }

        dfs(a,b,0);

        if (result == Integer.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    public static void dfs(int s, int e, int d){
        if (s == e){
            result = Math.min(result, d);
            return;
        }
        
        for (int i : list.get(s)){
            if (depth[i] > d){
                depth[i] = d;
                dfs(i,e,d+1);
            }
        }
    }
}