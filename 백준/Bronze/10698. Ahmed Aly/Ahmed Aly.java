import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 1; i <= t; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            String o = st.nextToken();
            int Y = Integer.parseInt(st.nextToken());
            st.nextToken();
            int Z = Integer.parseInt(st.nextToken());

            if (o.equals("+") && (X+Y==Z)){
                System.out.println("Case " + i + ": YES");
            } else if (o.equals("-") && (X-Y==Z)) {
                System.out.println("Case " + i + ": YES");
            } else {
                System.out.println("Case " + i + ": NO");
            }
        }
    }
}