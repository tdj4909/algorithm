import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int result = 0;
        List<Deque<Integer>> strings = new ArrayList<>();
        for (int i = 0; i < 6; i++){
            strings.add(new ArrayDeque<>());
        }

        while (N-->0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken())-1;
            int p = Integer.parseInt(st.nextToken());

            if(strings.get(n).isEmpty() || strings.get(n).peekLast() < p){
                strings.get(n).offerLast(p);
                result++;
            } else if (strings.get(n).peekLast() == p) {
                continue;
            } else {
                while (!strings.get(n).isEmpty() && strings.get(n).peekLast() > p){
                    strings.get(n).pollLast();
                    result++;
                }
                
                if (!strings.get(n).isEmpty() && strings.get(n).peekLast() == p) {
                    continue;
                } else {
                    strings.get(n).offerLast(p);
                    result++;
                }

            }
        }

        System.out.println(result);
    }
}