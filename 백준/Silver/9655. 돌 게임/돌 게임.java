import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    static int[] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        if (N == 1){
            System.out.println("SK");
        } else if (N == 2) {
            System.out.println("CY");
        } else {
            bfs();
            
            if (dp[N] % 2 == 1){
                System.out.println("SK");
            } else {
                System.out.println("CY");
            }
        }
    }

    static void bfs(){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(3);
        dp[1] = 1;
        dp[3] = 1;
        while (!queue.isEmpty()){
            int curr = queue.poll();

            if (curr + 1 <= N && dp[curr + 1] == 0){
                dp[curr+1] = dp[curr]+1;
                queue.offer(curr+1);
            }

            if (curr + 3 <= N && dp[curr + 3] == 0){
                dp[curr+3] = dp[curr]+1;
                queue.offer(curr+3);
            }

            if (dp[N] != 0){
                break;
            }
        }
    }
}