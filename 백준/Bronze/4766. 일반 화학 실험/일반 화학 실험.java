import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double m = Double.parseDouble(br.readLine());
        while (true){
            double c = Double.parseDouble(br.readLine());
            if (c == 999.0){
                break;
            }

            System.out.println(String.format("%.2f", c-m));
            m = c;
        }
    }
}