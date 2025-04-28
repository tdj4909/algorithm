import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (C-->0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];

            for (int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int sum = 0;
            for (int i : arr){
                sum += i;
            }
            double average = sum / 1.0 / N;

            double cnt = 0.0;
            for (int i : arr){
                if (i > average){
                    cnt++;
                }
            }
            System.out.println(String.format("%.3f", cnt/N*100) + "%");

        }
    }
}