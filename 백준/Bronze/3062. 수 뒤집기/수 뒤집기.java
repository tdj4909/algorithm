import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb1;
        StringBuilder sb2;
        while (T-- > 0){
            sb1 = new StringBuilder();
            sb2 = new StringBuilder();
            String s = br.readLine();
            sb1.append(s);
            sb1.reverse();
            sb2.append(Integer.parseInt(s)+Integer.parseInt(sb1.toString()));
            s = sb2.toString();
            sb2.reverse();
            if (s.contentEquals(sb2)){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}