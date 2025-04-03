import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[50001];
        Arrays.fill(dp,50000);
        for (int i = (int) Math.sqrt(50000); i >= 1; i--){
            int pow = (int) Math.pow(i,2);
            for (int j = 1; pow * j <= 50000; j++){
                dp[pow * j] = Math.min(dp[pow * j], j);
            }
            for (int j = 1; pow + j <= 50000; j++){
                dp[pow+j] = Math.min(dp[pow+j],dp[pow]+dp[j]);
            }
        }

        System.out.println(dp[n]);
    }
}