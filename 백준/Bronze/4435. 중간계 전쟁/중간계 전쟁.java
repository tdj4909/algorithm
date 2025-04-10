import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] g = new int[]{1,2,3,3,4,10};
        int[] s = new int[]{1,2,2,2,3,5,10};

        for (int i = 1; i <= T; i++){
            int gCnt = 0;
            int sCnt = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++){
                gCnt += g[j] * Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++){
                sCnt += s[j] * Integer.parseInt(st.nextToken());
            }

            if (gCnt > sCnt){
                System.out.println("Battle " + i + ": Good triumphs over Evil");
            } else if (gCnt < sCnt) {
                System.out.println("Battle "+i+": Evil eradicates all trace of Good");
            } else {
                System.out.println("Battle "+i+": No victor on this battle field");
            }
        }
    }
}