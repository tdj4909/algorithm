import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        while (!(s = br.readLine()).equals("#")){
            int cnt = 0;
            for (int i = 0; i < s.length()-1; i++){
                if (s.charAt(i) == '1'){
                    cnt++;
                }
            }

            if ((s.charAt(s.length()-1) == 'e' && cnt % 2 == 0)
                || (s.charAt(s.length()-1) == 'o' && cnt % 2 == 1)){
                sb.append(s.substring(0,s.length()-1) + "0\n");
            } else {
                sb.append(s.substring(0,s.length()-1) + "1\n");
            }
        }

        System.out.println(sb);
    }
}