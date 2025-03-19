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

//        for (int[] l : lcs){
//            System.out.println(Arrays.toString(l));
//        }
//        System.out.println("@@@@@@@@@@@");
//        int len = Math.min(a.length(), b.length());
//        for (int i = 1; i <= len; i++){
//                lcs[i][i] += (lcs[i-1][i] + lcs[i][i-1] + lcs[i-1][i-1]);
//        }
//
//        for (int[] l : lcs){
//            System.out.println(Arrays.toString(l));
//        }
        System.out.println(lcs[a.length()][b.length()]);
    }
}