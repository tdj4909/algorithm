import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int[][] lcs = new int[a.length()+1][b.length()+1];

        for (int i = 1; i <= a.length(); i++){
            for (int j = 1; j <= b.length(); j++){
                if (a.charAt(i-1) == b.charAt(j-1)){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int x = a.length();
        int y = b.length();
        while (true){
            if (lcs[x][y] == 0){
                break;
            }

            if (lcs[x-1][y] != lcs[x][y] && lcs[x-1][y] == lcs[x][y-1]){
                sb.append(a.charAt(x-1));
                x--;
                y--;
            } else {
                if (lcs[x-1][y] == lcs[x][y-1]){
                    x--;
                } else if (lcs[x-1][y] > lcs[x][y-1]){
                    x--;
                } else {
                    y--;
                }
            }

        }

        System.out.println(lcs[a.length()][b.length()]);
        if (sb.length() != 0) {
            sb.reverse();
            System.out.println(sb);
        }
    }
}