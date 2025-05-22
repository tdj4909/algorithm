import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Deque<Integer> score = new ArrayDeque<>();
        Deque<Integer> time = new ArrayDeque<>();
        int result = 0;

        while (N-->0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0){
                if (!time.isEmpty() && time.peekLast() == 1){
                    result += score.pollLast();
                    time.pollLast();
                } else if (!time.isEmpty()) {
                    time.offerLast(time.pollLast()-1);
                }
            } else {
                int A = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                if (T == 1){
                    result += A;
                } else {
                    score.offerLast(A);
                    time.offerLast(T-1);
                }
            }
        }

        System.out.println(result);
    }
}