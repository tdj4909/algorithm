import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            int t1 = n * s;
            int t2 = n * p + d;

            if (t1 > t2){
                System.out.println("parallelize");
            } else if (t1 < t2) {
                System.out.println("do not parallelize");
            } else {
                System.out.println("does not matter");
            }
        }
    }
}