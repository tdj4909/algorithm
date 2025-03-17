import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int A = 1;
        int B = 0;
        while (K-- > 0){
            int tmp = A;
            A = B;
            B += tmp;
        }
        System.out.println(A + " " + B);
    }
}