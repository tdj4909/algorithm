import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = br.readLine()).equals("#")){
            int result = 0;
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i) != ' '){
                    result += ((int)(s.charAt(i) - 'A') + 1) * (i + 1);
                }
            }
            System.out.println(result);
        }
    }
}