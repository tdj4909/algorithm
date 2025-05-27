import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Deque<Character> deque = new ArrayDeque<>();
        int result = 0;

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (deque.isEmpty() && c == ')'){
                result++;
            } else if (c == '(') {
                deque.offerLast(c);
            } else {
                deque.pollLast();
            }
        }
        result += deque.size();
        System.out.println(result);
    }
}