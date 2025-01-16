import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N-1; i++){
            for (int j = 0; j < N + 1 + i; j++){
                if (j == N - 1 - i || j == N - 1 + i){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < N * 2 - 1; i++){
            System.out.print("*");
        }
    }
}