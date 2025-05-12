import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-->0){
            String str = br.readLine();
            String s = str.toLowerCase();
            int g = 0;
            int b = 0;
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i) == 'g'){
                    g++;
                } else if (s.charAt(i) == 'b') {
                    b++;
                }
            }

            if (g>b){
                System.out.println(str + " is GOOD");
            } else if (g<b) {
                System.out.println(str + " is A BADDY");
            } else {
                System.out.println(str + " is NEUTRAL");
            }
        }
    }
}