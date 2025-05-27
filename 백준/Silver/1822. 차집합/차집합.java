import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());
        Set<Integer> A = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nA; i++){
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nB; i++){
            A.remove(Integer.parseInt(st.nextToken()));
        }

        System.out.println(A.size());
        if (!A.isEmpty()){
            List<Integer> list = new ArrayList<>(A);
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for (int i : list){
                sb.append(i).append(" ");
            }
            System.out.println(sb);
        }


    }


}