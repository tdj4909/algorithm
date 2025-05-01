import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String s;
        while ((s = br.readLine()) != null){
            st = new StringTokenizer(s);
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());

            System.out.println(String.format("%.2f",Math.round(a/b*100)/100.0));
        }

    }
}