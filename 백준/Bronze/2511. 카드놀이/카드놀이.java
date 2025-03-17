import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[10];
        for (int i = 0; i < 10; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] B = new int[10];
        for (int i = 0; i < 10; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        int scoreA = 0;
        int scoreB = 0;
        for (int i = 0; i < 10; i++){
            if (A[i] > B[i]){
                scoreA += 3;
            } else if (A[i] < B[i]) {
                scoreB += 3;
            } else {
                scoreA++;
                scoreB++;
            }
        }

        System.out.println(scoreA + " " + scoreB);
        if (scoreA > scoreB){
            System.out.println("A");
        } else if (scoreA < scoreB) {
            System.out.println("B");
        } else {
            for (int i = 9; i >= 0; i--){
                if (A[i] > B[i]){
                    System.out.println("A");
                    break;
                } else if (A[i] < B[i]) {
                    System.out.println("B");
                    break;
                }

                if (i == 0){
                    System.out.println("D");
                }
            }
        }
    }
}