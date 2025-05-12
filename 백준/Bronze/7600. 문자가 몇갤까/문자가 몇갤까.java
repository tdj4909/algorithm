import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        boolean[] alphabet;

        while (!(str= br.readLine().toLowerCase()).equals("#")){
            alphabet = new boolean[26];
            for (int i = 0; i < str.length(); i++){
                int n = str.charAt(i) - 'a';
                if (n>=0 && n<26 && !alphabet[n]){
                    alphabet[n] = true;
                }
            }

            int result = 0;
            for (boolean b : alphabet){
                if (b){
                    result++;
                }
            }

            System.out.println(result);
        }
    }
}