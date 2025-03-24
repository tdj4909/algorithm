import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sh = Integer.parseInt(st.nextToken());
            int sm = Integer.parseInt(st.nextToken());
            int ss = Integer.parseInt(st.nextToken());
            int eh = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int es = Integer.parseInt(st.nextToken());

            es -= ss;
            if (es < 0){
                em -= 1;
                es += 60;
            }

            em -= sm;
            if (em < 0){
                eh -= 1;
                em += 60;
            }

            eh -= sh;

            System.out.println(eh + " " + em + " " + es);
        }
    }
}