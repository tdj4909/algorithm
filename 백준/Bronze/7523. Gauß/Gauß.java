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

        for (int i = 1; i <= T; i++){
            st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            long result = 0;
            
            if (n<0 && m>0) {
                long pos = m * (m+1) / 2;
                long neg = -(-n * (-n+1) / 2);
                result = pos + neg;
            } else {
                result = (m+n)*(m-n+1)/2;
            }

            sb.append("Scenario #").append(i).append(":\n");
            sb.append(result).append("\n\n");
        }

        System.out.println(sb);
    }
}