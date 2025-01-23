import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String result = br.readLine();

        for (int i = 0; i < N-1; i++){
            String str = br.readLine();
            for (int j = 0; j < result.length(); j++){
                if (result.charAt(j) != str.charAt(j)){
                    result = result.substring(0, j) + "?" + result.substring(j+1);
                }
            }
        }

        System.out.println(result);
        br.close();
    }
}