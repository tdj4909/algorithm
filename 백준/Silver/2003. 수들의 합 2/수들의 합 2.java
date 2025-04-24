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
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];

        for (int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++){
            arr[i] += arr[i-1];
        }

        int left = 0;
        int right = N;
        int result = 0;

        while (left <= right && right <= N){
            if (arr[right]-arr[left] == M){
                result++;

                right--;
                left = 0;
            } else if (arr[right]-arr[left] < M) {
                right--;
                left = 0;
            } else {
                left++;
            }
        }

        System.out.println(result);
    }
}