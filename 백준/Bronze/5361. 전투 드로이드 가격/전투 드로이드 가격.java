import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] price = new double[]{350.34, 230.90, 190.55, 125.30, 180.90};
        StringTokenizer st;
        while (n-- > 0){
            st = new StringTokenizer(br.readLine());
            double result = 0.0;
            for (int i = 0; i < 5; i++){
                result += price[i] * Integer.parseInt(st.nextToken());
            }
            System.out.printf("$%.2f\n",result);
        }
    }
}