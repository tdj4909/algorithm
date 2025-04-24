import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        if (n == 2){
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = gcd(a,b);

            for (int i = 1; i <= result; i++){
                if (result % i == 0){
                    System.out.println(i);
                }
            }
        } else {
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int result = gcd(a,b);
            result = gcd(result, c);

            for (int i = 1; i <= result; i++){
                if (result % i == 0){
                    System.out.println(i);
                }
            }
        }

    }

    public static int gcd(int a, int b){
        if (b == 0){
            return a;
        }
        return gcd(b,a%b);
    }
}