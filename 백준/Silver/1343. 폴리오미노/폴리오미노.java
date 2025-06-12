import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (c == 'X'){
                if (deque.size() == 3){
                    deque.clear();
                    sb.append("AAAA");
                } else {
                    deque.offerLast(c);
                }
            } else if (c == '.'){
                if (deque.size() == 2){
                    deque.clear();
                    sb.append("BB.");
                } else if (deque.isEmpty()){
                    sb.append(".");
                } else {
                    System.out.println(-1);
                    return;
                }
            }
        }

        if (deque.size() == 2){
            deque.clear();
            sb.append("BB");
        }
        
        if (!deque.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }

    }
}