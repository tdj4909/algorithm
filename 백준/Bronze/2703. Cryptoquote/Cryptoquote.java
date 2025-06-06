import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            StringBuilder sb = new StringBuilder();
            String os = br.readLine();
            String key = br.readLine();

            for (int i = 0; i < os.length(); i++){
                if (os.charAt(i) == ' '){
                    sb.append(" ");
                } else {
                    sb.append(String.valueOf(key.charAt(os.charAt(i)-'A')));
                }
            }

            System.out.println(sb);
        }

    }
}