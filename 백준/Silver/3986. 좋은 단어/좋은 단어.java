import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < N; i++){
            String str = br.readLine();
            if (str.length() % 2 != 0){
                continue;
            }

            Deque<Character> deque = new ArrayDeque<>();
            for (int j = 0; j < str.length(); j++){
                deque.offerLast(str.charAt(j));
            }

            while (!deque.isEmpty()){
                boolean flag = true;
                for (int j = 0; j < deque.size(); j++){
                    if (deque.getFirst() == deque.getLast()){
                        deque.pollFirst();
                        deque.pollLast();
                        flag = false;
                        break;
                    } else {
                        deque.offerLast(deque.pollFirst());
                    }
                }
                if (flag){
                    break;
                }
            }
            if (deque.isEmpty()){
                result++;
            }
        }

        System.out.println(result);
    }
}