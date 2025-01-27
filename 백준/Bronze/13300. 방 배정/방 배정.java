import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] students = new int[6][2];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            students[Y-1][S]++;
        }

        int result = 0;
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 2; j++){
                result += (int) Math.ceil(students[i][j] / (double) K);
            }
        }

        System.out.println(result);
        br.close();
    }
}