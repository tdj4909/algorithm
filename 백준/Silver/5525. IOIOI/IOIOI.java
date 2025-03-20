import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        StringBuilder sb = new StringBuilder("I");
        while (N-- > 0){
            sb.append("OI");
        }

        int cnt = 0;
        String P = sb.toString();
        int lenP = P.length();

        int i = 0;
        int j = 0;
        boolean flag = true;
        while (i <= M-lenP){
            for (;j<lenP;j++){
                if (S.charAt(i+j) != P.charAt(j)){
                    flag = false;
                    break;
                }
            }

            if (flag){
                cnt++;
                i += 2;
                j--;
                while (i <= M-lenP && S.charAt(i+j) == 'I' && S.charAt(i+j-1) == 'O'){
                    cnt++;
                    i += 2;
                }
                i += j-2;
            } else {
                flag = true;
            }
            i++;
            j = 0;
        }

        System.out.println(cnt);
    }
}