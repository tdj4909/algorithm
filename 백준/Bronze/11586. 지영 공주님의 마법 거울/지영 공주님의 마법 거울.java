import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] face = new String[N];
        for (int i = 0; i < N; i++){
            face[i] = br.readLine();
        }
        int K = Integer.parseInt(br.readLine());
        String[] mirror = new String[N];
        if (K == 1){
            for (int i = 0; i < N; i++){
                mirror[i] = face[i];
            }
        } else if (K == 2) {
            for (int i = 0; i < N; i++){
                mirror[i] = "";
                for (int j = N-1; j >= 0; j--){
                    mirror[i] += face[i].charAt(j);
                }
            }
        } else {
            for (int i = 0; i < N; i++){
                mirror[i] = face[N-1-i];
            }
        }

        for (String s : mirror){
            System.out.println(s);
        }
    }
}