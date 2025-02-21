import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] alpha = new int[26];

        while (N-- > 0){
            String s = br.readLine();
            alpha[s.charAt(0)-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++){
            if (alpha[i] >= 5){
                sb.append((char) (i+'a'));
            }
        }

        if (sb.isEmpty()){
            System.out.println("PREDAJA");
        } else {
            System.out.println(sb.toString());
        }
    }
}