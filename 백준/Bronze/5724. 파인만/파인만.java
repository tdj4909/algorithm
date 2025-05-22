import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;

        while (true){
            N = Integer.parseInt(br.readLine());
            if (N == 0){
                break;
            }

            int result = 0;
            for (int i = 1; i <= N; i++){
                result += i*i;
            }
            System.out.println(result);
        }
    }
}