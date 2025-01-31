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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++){
            list.offer(i);
        }

        int result = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++){
            int idx = Integer.parseInt(st.nextToken());

            if (idx != list.getFirst()){
                if (list.indexOf(idx) <= list.size()/2){
                    while (idx != list.getFirst()){
                        list.offerLast(list.pollFirst());
                        result++;
                    }
                } else {
                    while (idx != list.getFirst()){
                        list.offerFirst(list.pollLast());
                        result++;
                    }
                }
            }
            list.pollFirst();
        }
        System.out.println(result);
    }
}