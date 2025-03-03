import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int[] alphabet = new int[26];

        while ((s = br.readLine()) != null){
            s = s.replaceAll(" ", "");
            for (int i = 0; i < s.length(); i++){
                alphabet[s.charAt(i) - 'a']++;
            }


        }

        int max = 0;
        for (int i = 0; i < 26; i++){
            max = Math.max(max, alphabet[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++){
            if (alphabet[i] == max){
                sb.append((char) (i+'a'));
            }
        }

        System.out.println(sb);
    }
}