import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = 0;
        int time = 0;

        while (true){
            time++;
            K++;
            if (K > N){
                K = 1;
            }
            
            N -= K;
            if (N == 0){
                break;
            }
        }

        System.out.println(time);
    }
}