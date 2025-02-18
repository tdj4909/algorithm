import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String s = br.readLine().replaceAll(" ", "");
            if (s.equals("*")){
                break;
            }

            boolean[] alphabet = new boolean[26];
            for (int i = 0; i < s.length(); i++){
                alphabet[s.charAt(i)-'a'] = true;
            }

            boolean flag = true;
            for (int i = 0; i < 26; i++){
                if (!alphabet[i]){
                    flag = false;
                    break;
                }
            }

            if (flag){
                System.out.println("Y");
            } else {
                System.out.println("N");
            }
        }
    }
}