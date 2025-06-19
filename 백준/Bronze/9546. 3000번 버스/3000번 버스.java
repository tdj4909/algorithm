import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++){
            int n = Integer.parseInt(br.readLine());
            double result = 1;
            for (int j = 1; j < n; j++){
                result = (result + 0.5) * 2;
            }
            System.out.printf("%.0f\n", result);
        }
    }
}