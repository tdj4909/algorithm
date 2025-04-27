import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String X = br.readLine();
        int len = X.length();

        if (len >= 3 && X.substring(0,2).equals("0x")){
            System.out.println(Integer.parseInt(X.substring(2),16));
        } else if (X.charAt(0) == '0') {
            System.out.println(Integer.parseInt(X.substring(1),8));
        } else {
            System.out.println(Integer.parseInt(X));
        }

    }
}