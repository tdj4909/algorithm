import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            int a3 = Integer.parseInt(st.nextToken());
            if (a1==0 && a2==0 && a3 ==0){
                break;
            }

            if ((a3 - a2) == (a2 - a1)){
                System.out.println("AP " + (a3 + (a3 - a2)));
            } else {
                System.out.println("GP " + (a3 * (a3 / a2)));
            }

        }
    }
}