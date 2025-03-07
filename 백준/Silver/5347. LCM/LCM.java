import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (n-- > 0){
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());

            sb.append(a * b / gcd(a, b) + "\n");
        }
        System.out.println(sb.toString());
    }

    static long gcd(long a, long b){
        while (b != 0){
            long tmp = a;
            a = b;
            b = tmp%b;
        }
        return a;
    }
}