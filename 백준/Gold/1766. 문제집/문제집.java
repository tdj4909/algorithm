import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] indegree;
    static StringBuilder sb;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        indegree = new int[N+1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            indegree[to]++;
        }

        for (int i = 1; i <= N; i++){
            Collections.sort(graph.get(i));
        }

        sb = new StringBuilder();
        visited = new boolean[N+1];
        dfs();

        System.out.println(sb);
    }

    static void dfs(){
        for (int i = 1; i < indegree.length; i++){
            if (indegree[i] == 0 && !visited[i]){
                visited[i] = true;
                sb.append(i).append(" ");

                for (int next : graph.get(i)){
                    indegree[next]--;
                }

                dfs();
            }
        }
    }
}