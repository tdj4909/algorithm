import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        int min;
        int max;

        max = Integer.parseInt(A.replaceAll("5","6")) + Integer.parseInt(B.replaceAll("5","6"));
        min = Integer.parseInt(A.replaceAll("6","5")) + Integer.parseInt(B.replaceAll("6","5"));

        System.out.println(min + " " + max);
    }
}