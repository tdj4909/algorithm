import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int sum = 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c >= 'a') {
                sum += c - 'a' + 1;
            } else {
                sum += c - 'A' + 27;
            }
        }

        boolean result = true;
        for (int i = 2; i <= (int) Math.sqrt(sum); i++){
            if (sum % i == 0){
                result = false;
                break;
            }
        }

        if (result){
            System.out.println("It is a prime word.");
        } else {
            System.out.println("It is not a prime word.");
        }
    }
}