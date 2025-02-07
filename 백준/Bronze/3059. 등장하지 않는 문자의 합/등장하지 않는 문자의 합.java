import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            String s = br.readLine();
            boolean[] table = new boolean[26];
            int result = 0;

            for (int i = 0; i < s.length(); i++){
                table[s.charAt(i) - 'A'] = true;
            }

            for (int i= 0; i < 26; i++){
                if (!table[i]){
                    result += i + 'A';
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}