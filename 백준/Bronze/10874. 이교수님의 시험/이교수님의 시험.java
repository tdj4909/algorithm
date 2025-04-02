import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++){
            boolean flag = true;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 10; j++){
                if ((j-1)%5+1 != Integer.parseInt(st.nextToken())){
                    flag = false;
                    break;
                }
            }
            if (flag){
                System.out.println(i);
            }
        }
    }
}