import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            int P1 = 0;
            int P2 = 0;
            int n = Integer.parseInt(br.readLine());
            while (n-- > 0){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String P1str = st.nextToken();
                String P2str = st.nextToken();

                if (!P1str.equals(P2str)){
                    if (P1str.equals("R") && P2str.equals("P") ||
                            P1str.equals("P") && P2str.equals("S") ||
                            P1str.equals("S") && P2str.equals("R")){
                        P2++;
                    } else {
                        P1++;
                    }
                }

            }

            if (P1 > P2){
                System.out.println("Player 1");
            } else if (P1 < P2) {
                System.out.println("Player 2");
            } else {
                System.out.println("TIE");
            }

        }
    }
}