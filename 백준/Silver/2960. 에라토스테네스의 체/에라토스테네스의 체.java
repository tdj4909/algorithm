import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int idx = 0;

        boolean[] prime = new boolean[N+1];
        prime[0] = true;
        prime[1] = true;

        boolean flag = false;
        for (int i = 2; i <= N; i++){
            for (int j = 1; i*j <= N; j++){
                if (!prime[i*j]){
                    prime[i*j] = true;
                    idx++;
                    if (idx == K){
                        System.out.println(i*j);
                        flag = true;
                        break;
                    }
                }
            }
            if (flag){
                break;
            }
        }

    }
}