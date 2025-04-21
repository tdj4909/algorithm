import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 1; i <= N; i++){
            String s = String.valueOf(i);
            int len = s.length();

            if (len < 3){
                result++;
                continue;
            } else if (i == 1000) {
                break;
            }

            if ((Integer.parseInt(String.valueOf(s.charAt(2))) - Integer.parseInt(String.valueOf(s.charAt(1))))
                == (Integer.parseInt(String.valueOf(s.charAt(1))) - Integer.parseInt(String.valueOf(s.charAt(0))))){
                result++;
            }

        }

        System.out.println(result);
    }
}