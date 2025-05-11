import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0){
                break;
            } else {
                int last = 0;
                for (int i = 0; i < n; i++){
                    int num = Integer.parseInt(st.nextToken());
                    if (num != last){
                        last = num;
                        System.out.print(num + " ");
                    }
                }
                System.out.println("$");
            }

        }

    }
}