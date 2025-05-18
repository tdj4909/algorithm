import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (A==B && B==C){
                System.out.println("Case #"+i+": equilateral");
            } else if ((A+B+C)-Math.max(Math.max(A,B),C) > Math.max(Math.max(A,B),C)) {
                if (A==B || A==C || B==C){
                    System.out.println("Case #"+i+": isosceles");
                } else {
                    System.out.println("Case #" + i + ": scalene");
                }
            } else {
                System.out.println("Case #"+i+": invalid!");
            }
        }


    }
}