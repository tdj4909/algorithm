import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Long[] koong = new Long[68];
        koong[0] = 1L;
        koong[1] = 1L;
        koong[2] = 2L;
        koong[3] = 4L;
        for (int i = 4; i <= 67; i++){
            koong[i] = koong[i-1] + koong[i-2] + koong[i-3] + koong[i-4];
        }

        while (t-- > 0){
            int n = Integer.parseInt(br.readLine());
            System.out.println(koong[n]);
        }
    }
}