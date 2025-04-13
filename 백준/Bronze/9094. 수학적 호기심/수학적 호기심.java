import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (T-->0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int result = 0;
            for (int i = 1; i <= n-2; i++){
                for (int j = i+1; j <= n-1; j++){
                    if ((i*i+j*j+m)%(i*j) == 0){
                        result++;
                    }
                }
            }

            System.out.println(result);
        }
    }
}