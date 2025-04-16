import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (T-->0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int result = 0;

            while (N-->0){
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                double f = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                if (D <= v*f/c){
                    result++;
                }
            }

            System.out.println(result);
        }

    }
}