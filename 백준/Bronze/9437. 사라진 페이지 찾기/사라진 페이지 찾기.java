import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (st.countTokens() != 1){
            int N = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            if (N/2 >= P){
                if (P%2 == 0){
                    sb.append((P-1) + " " + (N-P+1) + " " + (N-P+2) + "\n");
                } else {
                    sb.append((P+1) + " " + (N-P) + " " + (N-P+1) + "\n");
                }
            } else {
                if (P%2 == 0){
                    sb.append((N-P+1) + " " + (N-P+2) + " " + (P-1) + "\n");
                } else {
                    sb.append((N-P) + " " + (N-P+1) + " " + (P+1) + "\n");
                }
            }

            st = new StringTokenizer(br.readLine());
        }

        System.out.println(sb);
    }
}