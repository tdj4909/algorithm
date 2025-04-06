import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++){
            deque.offerLast(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()){
            sb.append(deque.pollFirst() + " ");
            if (deque.isEmpty()){
                break;
            }
            deque.offerLast(deque.pollFirst());
        }

        System.out.println(sb);
    }
}