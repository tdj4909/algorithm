import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            int[] alphabet = new int[26];
            String s = br.readLine();
            s = s.toLowerCase();

            for (int j = 0; j < s.length(); j++){
                int a = s.charAt(j) - 'a';
                if (a >= 0 && a < 26){
                    alphabet[a]++;
                }
            }

            int result = Integer.MAX_VALUE;
            for (int j : alphabet){
                result = Math.min(result, j);
            }

            if (result == 3){
                System.out.println("Case " + i + ": Triple pangram!!!");
            } else if (result == 2) {
                System.out.println("Case " + i + ": Double pangram!!");
            } else if (result == 1) {
                System.out.println("Case " + i + ": Pangram!");
            } else if (result == 0) {
                System.out.println("Case " + i + ": Not a pangram");
            }

        }

    }
}