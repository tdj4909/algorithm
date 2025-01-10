import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            String x = st.nextToken();
            String y = st.nextToken();

            System.out.print("Distances: ");
            for (int j = 0; j < x.length(); j++){
                char chX = x.charAt(j);
                char chY = y.charAt(j);
                System.out.print(chY >= chX ? chY - chX : (chY + 26) - chX);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}