import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] floor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        floor = new int[F+1];
        floor[0] = -1;

        bfs(F, S, G, U, D);

        if (floor[G] == 0){
            System.out.println("use the stairs");
        } else {
            System.out.println(floor[G]-1);
        }

    }

    static void bfs(int f, int s, int g, int u, int d){
        Queue<Integer> queue = new ArrayDeque<>();
        floor[s] = 1;
        queue.offer(s);
        while (!queue.isEmpty()){
            int curr = queue.poll();
            for (int i = 0; i < 2; i++){
                if (i == 0){
                    if (curr + u <= f && floor[curr + u] == 0) {
                        floor[curr + u] = floor[curr] + 1;
                        if (curr + u == g) {
                            return;
                        }
                        queue.offer(curr + u);
                    }
                } else {
                    if (curr - d > 0 && floor[curr - d] == 0) {
                        floor[curr - d] = floor[curr] + 1;
                        if (curr - d == g) {
                            return;
                        }
                        queue.offer(curr - d);
                    }
                }
            }
        }
    }
}