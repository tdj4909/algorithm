import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++){
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++){
                if (s.charAt(j) == 'Z'){
                    sb.append('A');
                } else {
                    sb.append((char) (s.charAt(j)+1));
                }
            }
            System.out.println("String #" + i);
            System.out.println(sb);
            System.out.println();
        }
    }
}