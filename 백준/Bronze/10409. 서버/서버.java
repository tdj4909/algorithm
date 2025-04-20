import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[] time = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            time[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i = 0; i < n; i++){
            T -= time[i];
            if (T < 0){
                break;
            } else {
                result++;
            }
        }

        System.out.println(result);
    }
}