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
        for (int i = 0; i < M-P.length()+1; i++){
            boolean flag = true;
            for (int j = 0; j < P.length(); j++){
                if (S.charAt(i+j) != P.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if (flag){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}