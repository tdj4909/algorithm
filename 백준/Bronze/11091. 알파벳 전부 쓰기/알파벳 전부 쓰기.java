import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0){
            boolean[] alphabet = new boolean[26];
            String s = br.readLine().toLowerCase();
            for (int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                if (ch >= 'a' && ch <= 'z'){
                    alphabet[ch - 'a'] = true;
                }
            }

            boolean flag = true;
            for (boolean b : alphabet){
                if (!b){
                    flag = false;
                    break;
                }
            }

            if (flag){
                sb.append("pangram\n");
            } else {
                sb.append("missing ");
                for (int i = 0; i < 26; i++){
                    if (!alphabet[i]){
                        sb.append((char)(i+'a'));
                    }
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}