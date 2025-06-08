import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());
        N /= 100;
        N *= 100;

        while (N%F != 0){
            N++;
        }

        String result = String.valueOf(N);
        if (result.length() < 2){
            result = "0" + result;
        }
        System.out.println(result.substring(result.length()-2));
    }
}