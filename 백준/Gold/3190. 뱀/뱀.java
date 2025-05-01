import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dx = new int[]{0,1,0,-1};
    static int[] dy = new int[]{1,0,-1,0};
    static int[][] board;
    static Map<Integer,String> map;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        board = new int[N][N];
        StringTokenizer st;

        for (int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x-1][y-1] = -1;
        }
        board[0][0] = 1;

        int L = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        for (int i = 0; i < L; i++){
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        dummy(0,1,0,0,0,1);

        System.out.println(result);
    }

    static void dummy(int xf, int yf, int xe, int ye, int d, int r){
        if (xf<0 || xf>=N || yf<0 || yf>=N || board[xf][yf] > 0){
            result = r;
            return;
        } else if (board[xf][yf] == 0) {
            int i = xe;
            int j = ye;
            xe += dx[board[i][j]-1];
            ye += dy[board[i][j]-1];
            board[i][j] = 0;
        }

        if (map.containsKey(r)){
            if (map.get(r).equals("L")){
                d--;
                if (d<0){
                    d = 3;
                }
            } else {
                d++;
                if (d>3){
                    d = 0;
                }
            }

            board[xf][yf] = d+1;
            xf += dx[d];
            yf += dy[d];
            dummy(xf,yf,xe,ye,d,r+1);
        } else {
            board[xf][yf] = d+1;
            xf += dx[d];
            yf += dy[d];
            dummy(xf,yf,xe,ye,d,r+1);
        }
    }
}