import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[1001];
        int idx = 1;

        for (int i = 1; i <= 1000; i++){
            for (int j = 0; j < i; j++){
                arr[idx] = i;
                idx++;
                if (idx == 1001){
                    break;
                }
            }
            if (idx == 1001){
                break;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int result = 0;

        for (int i = A; i <= B; i++){
            result += arr[i];
        }

        System.out.println(result);
    }
}