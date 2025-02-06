import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (Integer n : list){
            sb.append(n).append(" ");
        }

        System.out.println(sb);
    }
}