import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (N != 0){
            sb.append(String.valueOf(N%2));
            N /= 2;
        }
        sb.reverse();
        System.out.println(sb);
    }
}