import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        int[] num = new int[10];
        for (int i = 0; i < N.length(); i++){
            num[Integer.parseInt(String.valueOf(N.charAt(i)))]++;
        }

        while (true){
            if (num[6] > num[9]){
                num[6]--;
                num[9]++;
            } else {
                break;
            }
        }

        while (true){
            if (num[6] < num[9]){
                num[6]++;
                num[9]--;
            } else {
                break;
            }
        }

        System.out.println(Arrays.stream(num).max().getAsInt());

        br.close();
    }
}