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
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (deque.size() > 2 && c=='P'){
                char l1 = deque.pollLast();
                char l2 = deque.pollLast();
                char l3 = deque.pollLast();
                if (l1=='A' && l2=='P' && l3=='P'){
                    deque.offerLast(c);
                } else {
                    deque.offerLast(l3);
                    deque.offerLast(l2);
                    deque.offerLast(l1);
                    deque.offerLast(c);
                }
            } else {
                deque.offerLast(c);
            }
        }

        if (deque.size()==1 && deque.peekLast()=='P'){
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}