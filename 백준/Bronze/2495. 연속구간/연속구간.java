import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++){
            int result = 1;
            int tmp = 1;
            String str = br.readLine();

            for (int j = 0; j < 7; j++){
                if (str.charAt(j) == str.charAt(j+1)){
                    tmp++;
                    result = Math.max(result, tmp);
                } else {
                    tmp = 1;
                }
            }

            System.out.println(result);
        }
        br.close();
    }
}