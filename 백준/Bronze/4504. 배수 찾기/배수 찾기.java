import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        while (true){
            int m = Integer.parseInt(br.readLine());
            if (m == 0){
                break;
            } else if (m % n == 0) {
                System.out.println(m + " is a multiple of " + n + ".");
            } else {
                System.out.println(m + " is NOT a multiple of " + n + ".");
            }


        }

        br.close();
    }
}