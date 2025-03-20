import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int zero = 0;
        int one = 0;
        char index = S.charAt(0);
        if (index == '0'){
            zero++;
        } else {
            one++;
        }
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != index){
                index = S.charAt(i);
                if (index == '0'){
                    zero++;
                } else {
                    one++;
                }
            }
        }

        System.out.println(Math.min(zero,one));
    }
}