import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-->0){
            String s = br.readLine().toLowerCase();
            boolean result = true;
            for (int i = 0; i < s.length()/2; i++){
                if (s.charAt(i) != s.charAt(s.length()-1-i)){
                    result = false;
                    break;
                }
            }

            if (result){
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}