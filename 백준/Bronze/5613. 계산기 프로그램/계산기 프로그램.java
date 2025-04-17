import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String o = "";
        int n = 0;
        int result = Integer.parseInt(br.readLine());

        while (true){
            o = br.readLine();
            if (o.equals("=")){
                break;
            }

            n = Integer.parseInt(br.readLine());
            if (o.equals("+")){
                result += n;
            } else if (o.equals("-")) {
                result -= n;
            } else if (o.equals("*")) {
                result *= n;
            } else {
                result /= n;
            }

        }

        System.out.println(result);
    }
}