import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(st.nextToken().charAt(0)).toUpperCase());

        while (st.hasMoreTokens()){
            String s = st.nextToken();
            if (!(s.equals("i") || s.equals("pa") || s.equals("te") || s.equals("ni") || s.equals("niti") || s.equals("a") || s.equals("ali") || s.equals("nego") || s.equals("no") || s.equals("ili"))){
                sb.append(String.valueOf(s.charAt(0)).toUpperCase());
            }
        }

        System.out.println(sb);
    }
}