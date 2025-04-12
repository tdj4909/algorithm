import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            int d = Integer.parseInt(br.readLine());
            int result = 0;
            for (int i = 0; i < d; i++){
                if ((i+i*i) > d){
                    break;
                }
                result = i;
            }
            System.out.println(result);
        }
    }
}