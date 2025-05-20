import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        int h1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        int s1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), ":");
        int h2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());

        int rs = s2 - s1;
        if (rs < 0){
            rs += 60;
            m2--;
        }
        int rm = m2 - m1;
        if (rm < 0){
            rm += 60;
            h2--;
        }
        int rh = h2 - h1;
        if (rh < 0){
            rh += 24;
        }

        if (rh==0 && rm==0 && rs==0){
            rh = 24;
        }
        System.out.printf("%02d:%02d:%02d", rh, rm, rs);
    }
}