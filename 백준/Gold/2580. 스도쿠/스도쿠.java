import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static ArrayList<int[]> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0){
                    list.add(new int[]{i,j});
                }
            }
        }

        bt(0);

        System.out.println(sb);
    }

    static boolean bt(int n){
        if (n == list.size()){
            for (int[] b : board){
                for (int a : b){
                    sb.append(a).append(" ");
                }
                sb.append("\n");
            }
            return true;
        }

        int x = list.get(n)[0];
        int y = list.get(n)[1];

        for (int i = 1; i <= 9; i++){
            boolean flag = true;
            // 가로 줄 i 유효성 검사
            for (int j = 0; j < 9; j++){
                if (board[x][j] == i){
                    flag = false;
                    break;
                }
            }
            if (!flag){
                continue;
            }
            // 세로 줄 i 유효성 검사
            for (int j = 0; j < 9; j++){
                if (board[j][y] == i){
                    flag = false;
                    break;
                }
            }
            if (!flag){
                continue;
            }
            // 해당 3x3 칸 i 유효성 검사
            for (int a = x/3*3; a < x/3*3+3; a++){
                for (int b = y/3*3; b < y/3*3+3; b++){
                    if (board[a][b] == i){
                        flag = false;
                        break;
                    }
                }
            }
            if (!flag){
                continue;
            }
            // 모두 통과하면
            board[x][y] = i;
            if (bt(n+1)){
                break;
            }
            // 대입한 i 값 다시 0 으로
            board[x][y] = 0;
        }
        return false;
    }

}