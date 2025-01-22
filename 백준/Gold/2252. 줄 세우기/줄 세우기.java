import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] indegree;
    static ArrayList<Integer> result;

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

        result = new ArrayList<>();
        Kahn();

        for (int i : result){
            System.out.print(i);
            System.out.print(" ");
        }

        br.close();
    }

    static void Kahn(){
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i < indegree.length; i++){
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            int curr = queue.poll();
            result.add(curr);

            for (int next : graph.get(curr)){
                indegree[next]--;
                if (indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
    }
}