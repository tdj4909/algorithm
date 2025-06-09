import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int len = s.length()/K;
        char[][] arr = new char[len][K];
        int idx = 0;

        for (int i = 0; i < len; i++){
            if (i % 2 == 0){
                for (int j = 0; j < K; j++){
                    arr[i][j] = s.charAt(idx);
                    idx++;
                }
            } else {
                for (int j = K-1; j >= 0; j--){
                    arr[i][j] = s.charAt(idx);
                    idx++;
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++){
            for (int j = 0; j < len; j++){
                sb.append(arr[j][i]);
            }
        }

        System.out.println(sb.toString());
    }
}