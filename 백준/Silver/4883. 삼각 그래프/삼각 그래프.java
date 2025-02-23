import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0){
                break;
            }
            idx++;

            int[][] graph = new int[N][3];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            graph[0][2] += graph[0][1];
            for (int i = 0; i < 3; i++) {

                if (i == 0) {
                    graph[1][0] += graph[0][1];
                } else if (i == 1) {
                    graph[1][1] += Math.min(Math.min(graph[0][1], graph[1][0]), graph[0][2]);
                } else {
                    graph[1][2] += Math.min(Math.min(graph[0][1], graph[0][2]), graph[1][1]);
                }
            }
            if (N > 2) {
                for (int i = 2; i < N; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (j == 0) {
                            graph[i][j] += Math.min(graph[i - 1][j], graph[i - 1][j + 1]);
                        } else if (j == 1) {
                            graph[i][j] += Math.min(Math.min(Math.min(graph[i - 1][j - 1], graph[i][j-1]), graph[i - 1][j]), graph[i - 1][j + 1]);
                        } else {
                            graph[i][j] += Math.min(Math.min(graph[i - 1][j], graph[i][j-1]), graph[i - 1][j - 1]);
                        }
                    }
                }
            }
            
            sb.append(idx + ". " + graph[N - 1][1] + "\n");
        }
        System.out.println(sb.toString());
    }
}