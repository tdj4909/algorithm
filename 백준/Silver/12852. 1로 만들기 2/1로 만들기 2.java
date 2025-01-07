import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1][2];
        for (int i = 0; i<N+1; i++){
            dp[i][0] = Integer.MAX_VALUE;
        }

        recur(N,0);

        if (N==1){
            System.out.println(0);
        } else {
            System.out.println(dp[1][0]);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int idx = 1;
        while (idx < N){
            arrayList.add(idx);
            idx = dp[idx][1];
        }
        arrayList.add(N);
        for (int i = arrayList.size()-1; i >= 0; i--){
            System.out.print(arrayList.get(i) + " ");
        }
        br.close();
    }

    public static void recur(int x, int cnt){
        if (x == 1){
            return;
        }
        if (x % 3 == 0){
            if (dp[x/3][0] > cnt+1) {
                dp[x/3][0] = cnt + 1;
                dp[x/3][1] = x;
                recur(x / 3, cnt + 1);
            }
        }
        if (x % 2 == 0) {
            if (dp[x/2][0] > cnt+1) {
                dp[x/2][0] = cnt+1;
                dp[x/2][1] = x;
                recur(x / 2, cnt + 1);
            }
        }
        if (dp[x-1][0] > cnt+1) {
            dp[x-1][0] = cnt + 1;
            dp[x-1][1] = x;
            recur(x - 1, cnt + 1);
        }
    }
}