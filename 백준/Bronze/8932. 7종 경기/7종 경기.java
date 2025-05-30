import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-->0){
            st = new StringTokenizer(br.readLine());
            double s1 = Double.parseDouble(st.nextToken());
            double s2 = Double.parseDouble(st.nextToken());
            double s3 = Double.parseDouble(st.nextToken());
            double s4 = Double.parseDouble(st.nextToken());
            double s5 = Double.parseDouble(st.nextToken());
            double s6 = Double.parseDouble(st.nextToken());
            double s7 = Double.parseDouble(st.nextToken());

            int result = 0;

            result += 9.23076 * Math.pow(26.7-s1, 1.835);
            result += 4.99087 * Math.pow(42.5-s4, 1.81);
            result += 0.11193 * Math.pow(254-s7, 1.88);
            result += 1.84523 * Math.pow(s2-75, 1.348);
            result += 56.0211 * Math.pow(s3-1.5, 1.05);
            result += 0.188807 * Math.pow(s5-210, 1.41);
            result += 15.9803 * Math.pow(s6-3.8, 1.04);

            System.out.println(result);
        }

    }
}