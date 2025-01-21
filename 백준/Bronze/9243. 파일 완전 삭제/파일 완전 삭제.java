import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();
        String ans = br.readLine();

        for (int i = 0; i < N; i++){
            for (int j = 0; j < str.length; j++){
                if (str[j] == '0'){
                    str[j] = '1';
                } else {
                    str[j] = '0';
                }
            }
        }

        if (String.valueOf(str).equals(ans)){
            System.out.println("Deletion succeeded");
        } else {
            System.out.println("Deletion failed");
        }

        br.close();
    }
}