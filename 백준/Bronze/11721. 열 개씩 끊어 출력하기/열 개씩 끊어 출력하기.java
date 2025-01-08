import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for (int i = 0; i < str.length() / 10 + 1; i++){
            if (i == str.length()/10){
                System.out.println(str.substring(10*i));
            } else {
                System.out.println(str.substring(10 * i, 10 * (i + 1)));
            }
        }
    }
}