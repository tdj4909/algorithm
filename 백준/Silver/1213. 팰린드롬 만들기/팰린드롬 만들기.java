import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] alpha = new int[26];
        for (int i = 0; i < str.length(); i++){
            alpha[str.charAt(i) - 'A']++;
        }

        boolean chk = true;
        if (str.length() % 2 == 0){
            for (int i = 0; i < 26; i++){
                if (alpha[i] % 2 == 1){
                    chk = false;
                    break;
                }
            }
        } else {
            boolean odd = true;
            for (int i = 0; i < 26; i++){
                if (alpha[i] % 2 == 1){
                    if (odd){
                        odd = false;
                    } else {
                        chk = false;
                        break;
                    }
                }
            }
        }

        if (chk){
            StringBuilder sb = new StringBuilder();
            char tmp = 0;
            for (int i = 0; i < 26; i++){
                if (alpha[i] % 2 == 1){
                    tmp = (char) (i + 'A');
                }

                for (int j = 0; j < alpha[i]/2; j++){
                    sb.append(((char) (i+'A')));
                }
            }
            StringBuilder sb1 = new StringBuilder();
            sb1.append(sb);
            if (tmp != 0){
                sb.append(tmp);
            }
            sb1.reverse();
            sb.append(sb1);
            System.out.println(sb);
        } else {
            System.out.println("I'm Sorry Hansoo");
        }
    }
}