import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int max = 0;
        int min = 256;

        int[][] height = new int[N][M];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                int h = Integer.parseInt(st.nextToken());
                height[i][j] = h;
                max = Math.max(max, h);
                min = Math.min(min, h);
            }
        }

        int resultTime = Integer.MAX_VALUE;
        int resultHeight = 0;
        for (int k = min; k <= max; k++){
            int tmpT = 0;
            int tmpB = B;
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    if (height[i][j] > k){
                        tmpT += (height[i][j] - k) * 2;
                        tmpB += height[i][j] - k;
                    } else if (height[i][j] < k) {
                        tmpT += k - height[i][j];
                        tmpB -= k - height[i][j];
                    }
                }
            }

            if (tmpB >= 0 && tmpT <= resultTime){
                resultTime = tmpT;
                resultHeight = k;
            }
        }

        System.out.println(resultTime + " " + resultHeight);
    }
}