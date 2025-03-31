import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+1];
            int sum = 0;
            for (int i = 1; i <= n; i++){
                arr[i] = Integer.parseInt(br.readLine());
                sum += arr[i];
            }

            int idx = 0;
            int max = 0;
            for (int i = 1; i <= n; i++){
                if (arr[i] > max){
                    idx = i;
                    max = arr[i];
                } else if (arr[i] == max) {
                    idx = 0;
                }
            }

            if (idx == 0){
                System.out.println("no winner");
            } else {
                if (max > sum/2){
                    System.out.println("majority winner " + idx);
                } else {
                    System.out.println("minority winner " + idx);
                }
            }
        }
    }
}