import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] vowel = new char[]{'a','e','i','o','u'};

        if (s.length() < 3){
            System.out.println(s);
        } else {
            for (int i = 1; i < s.length()-1; i++){
                for (int j = 0; j < 5; j++){
                    if (s.charAt(i) == 'p' && s.charAt(i-1) == vowel[j] && s.charAt(i+1) == vowel[j]){
                        s = s.substring(0,i) + "11" + s.substring(i+2);
                        break;
                    }
                }
            }

            s = s.replaceAll("11", "");
            System.out.println(s);
        }

    }
}