import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            String s1 = br.readLine();
            String s2 = br.readLine();

            int result = 0;
            for (int i = 0; i < s1.length(); i++){
                if (s1.charAt(i) != s2.charAt(i)){
                    result++;
                }
            }

            System.out.println("Hamming distance is " + result + ".");
        }
    }
}