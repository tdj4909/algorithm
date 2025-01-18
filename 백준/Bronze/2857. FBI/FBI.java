import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 6; i++){
            String str = br.readLine();
            for (int j = 0; j < str.length()-2; j++){
                if (str.charAt(j) == 'F' && str.charAt(j+1) == 'B' && str.charAt(j+2) == 'I'){
                    sb.append(i + " ");
                    break;
                }
            }
        }

        if (sb.length() == 0){
            System.out.println("HE GOT AWAY!");
        } else {
            System.out.println(sb);
        }

        br.close();
    }
}