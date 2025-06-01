import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[1001];
        Deque<Integer> q = new ArrayDeque<>();
        seq[1] = 1;
        seq[3] = 1;
        q.offerLast(1);
        q.offerLast(3);
        while (!q.isEmpty()){
            int n = q.pollFirst();
            if (n+1 <= 1000 && seq[n+1] == 0){
                seq[n+1] = -seq[n];
                q.offerLast(n+1);
            }

            if (n+3 <= 1000 && seq[n+3] == 0){
                seq[n+3] = -seq[n];
                q.offerLast(n+3);
            }
        }

        if (seq[N] == -1){
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}