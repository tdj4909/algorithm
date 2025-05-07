import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] s = new String[N];
        String[] rs = new String[N];

        for (int i = 0; i < N; i++){
            s[i] = br.readLine();
        }
        for (int i = 0; i < N; i++){
            rs[i] = br.readLine();
        }

        boolean result = true;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (s[i].charAt(j) != rs[i].charAt(j*2) || s[i].charAt(j) != rs[i].charAt(j*2+1)){
                    result = false;
                    break;
                }
            }
            if (!result){
                break;
            }
        }

        if (result){
            System.out.println("Eyfa");
        } else {
            System.out.println("Not Eyfa");
        }

    }
}