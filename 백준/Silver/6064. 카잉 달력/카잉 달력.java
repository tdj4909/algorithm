import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (T-->0){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int max = M*N/GCD(M,N);
            int result = -1;

            for (int i = 0; i * M + x <= max; i++) {
                if ((i * M + x) % N == y || ((i * M + x) % N == 0 && N == y)) {
                    result = i * M + x;
                    break;
                }
            }


            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    public static int GCD(int a, int b){
        return b == 0 ? a : GCD(b, a%b);
    }
}