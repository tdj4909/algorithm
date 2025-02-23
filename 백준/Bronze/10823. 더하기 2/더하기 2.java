import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        StringBuilder sb = new StringBuilder();
        String s = "";

        while ((s = br.readLine()) != null) {
            sb.append(s);
        }

        StringTokenizer st = new StringTokenizer(sb.toString(), ",");

        while (st.hasMoreTokens()) {
            result += Integer.parseInt(st.nextToken());
        }

        System.out.println(result);
    }
}