import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] board = new String[8];
        for (int i = 0; i < 8; i++){
            board[i] = br.readLine();
        }
        int result = 0;
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (i%2==1 && j%2==1 && board[i].charAt(j) == 'F'){
                    result++;
                } else if (i%2==0 && j%2==0 && board[i].charAt(j) == 'F') {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}