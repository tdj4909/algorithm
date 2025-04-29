import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++){
            queue.offer(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        for (int i = 0; i < N-1; i++){
            int a = queue.poll();
            int b = queue.poll();
            queue.offer(a+b);
            result += a+b;
        }

        System.out.println(result);
    }
}