import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int max = Math.max(Math.max(a,b),c);

            if ((a*a + b*b) == c*c && max == c
                || (a*a + c*c) == b*b && max == b
                || (b*b + c*c) == a*a && max == a){
                System.out.println( "Scenario #" + i + ":");
                System.out.println("yes\n");
            } else {
                System.out.println( "Scenario #" + i + ":");
                System.out.println("no\n");
            }
        }
    }
}