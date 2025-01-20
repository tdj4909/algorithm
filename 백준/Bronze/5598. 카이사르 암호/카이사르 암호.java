import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++){
            char ch = (char) (str.charAt(i) - 3);
            if (ch < 'A'){
                ch += 26;
            }
            System.out.print(ch);
        }

        br.close();
    }
}