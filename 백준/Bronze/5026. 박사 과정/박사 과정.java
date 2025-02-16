import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (N-- > 0) {
            String s = br.readLine();
            if (s.charAt(1) == '='){
                System.out.println("skipped");
            } else {
                st = new StringTokenizer(s, "+");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                System.out.println(a+b);
            }
        }
        
    }
}