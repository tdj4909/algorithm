import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> primeList = new ArrayList<Integer>();
        primeList.add(0);
        for (int i = 2; i <= N; i++) {
            boolean prime = true;
            for (int j = 2; j <= Math.sqrt(N); j++) {
                if (i == j){
                    continue;
                }
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime){
                primeList.add(i);
            }
        }
        for (int i = 1; i < primeList.size(); i++){
            primeList.set(i, primeList.get(i) + primeList.get(i-1));
        }

        int left = 0;
        int right = 0;
        int result = 0;
        while (right < primeList.size()){
            if (primeList.get(right) - primeList.get(left) < N){
                right++;
            } else if (primeList.get(right) - primeList.get(left) > N) {
                left++;
            } else {
                result++;
                right++;
                left++;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}