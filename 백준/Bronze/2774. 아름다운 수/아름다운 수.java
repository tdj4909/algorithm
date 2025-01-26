import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++){
            boolean[] num = new boolean[10];
            String X = sc.next();

            for (int j = 0; j < X.length(); j++){
                num[Integer.parseInt(String.valueOf(X.charAt(j)))] = true;
            }

            int result = 0;
            for (boolean b : num){
                if (b){
                    result++;
                }
            }

            System.out.println(result);
        }

        sc.close();
    }
}