import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[2000003];
        dp[1] = 1;
        dp[2000002] = 1;

        if (n == 0){
            System.out.println(0);
            System.out.println(0);
        } else if (n == 1){
            System.out.println(1);
            System.out.println(1);
        } else {
            if (n > 1) {
                for (int i = 2; i <= n; i++) {
                    dp[i] = (dp[i-1]%1000000000 + dp[i-2]%1000000000)%1000000000;
                }
                System.out.println(1);
                System.out.println(dp[n]);
            } else {
                for (int i = -1; i >= n; i--){
                    dp[2000001+i] = (dp[2000001+i+2]%1000000000 - dp[2000001+i+1]%1000000000)%1000000000;
                }
                if (dp[2000001+n] < 0){
                    System.out.println(-1);
                    System.out.println(-dp[2000001+n]);
                } else if (dp[2000001+n] > 0) {
                    System.out.println(1);
                    System.out.println(dp[2000001+n]);
                } else {
                    System.out.println(0);
                    System.out.println(0);
                }
            }
        }
    }
}