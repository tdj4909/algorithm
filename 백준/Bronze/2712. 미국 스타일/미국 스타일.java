import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double d = Double.parseDouble(st.nextToken());
            String s = st.nextToken();
            
            if (s.equals("kg")){
                System.out.printf("%.4f lb\n",Math.round(d*2.2046*10000)/10000.0);
            } else if (s.equals("lb")) {
                System.out.printf("%.4f kg\n",Math.round(d*0.4536*10000)/10000.0);
            } else if (s.equals("l")) {
                System.out.printf("%.4f g\n",Math.round(d*0.2642*10000)/10000.0);
            } else {
                System.out.printf("%.4f l\n",Math.round(d*3.7854*10000)/10000.0);
            }
        }
    }
}