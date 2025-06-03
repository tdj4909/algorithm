import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            int n = Integer.parseInt(br.readLine());
            boolean[] open = new boolean[n+1];
            for (int i = 1; i <= n; i++){
                int idx = 1;
                while (i*idx <= n){
                    open[i*idx] = !open[i*idx];
                    idx++;
                }
            }

            int result = 0;
            for (boolean b: open){
                if (b){
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}