import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cnt = 0;
    static int r, c;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        Z(N,0, 0);

        System.out.println(result);
    }

    static void Z(int n, int x, int y){
        if (n == 1){
            if (x == r && y == c){
                result = cnt;
                return;
            } else {
                cnt++;
            }

            if (x == r && y+1 == c){
                result = cnt;
                return;
            } else {
                cnt++;
            }

            if (x+1 == r && y == c){
                result = cnt;
                return;
            } else {
                cnt++;
            }

            if (x+1 == r && y+1 == c){
                result = cnt;
                return;
            } else {
                cnt++;
            }

            return;
        }

        if (r >= x && r < x + (int) Math.pow(2, n-1)
                && c >= y && c < y + (int) Math.pow(2, n-1)){
            Z(n-1, x, y);
        } else if (r >= x && r < x + (int) Math.pow(2, n-1)
                && c >= y + (int) Math.pow(2, n-1)){
            cnt += (int) Math.pow(2, n-1) * (int) Math.pow(2, n-1);
            Z(n-1, x, y + (int) Math.pow(2, n-1));
        } else if (r >= x + (int) Math.pow(2, n-1)
                && c >= y && c < y + (int) Math.pow(2, n-1)){
            cnt += ((int) Math.pow(2, n-1) * (int) Math.pow(2, n-1)) * 2;
            Z(n-1, x + (int) Math.pow(2, n-1), y);
        } else {
            cnt += ((int) Math.pow(2, n-1) * (int) Math.pow(2, n-1)) * 3;
            Z(n-1, x + (int) Math.pow(2, n-1), y + (int) Math.pow(2, n-1));
        }

    }
}