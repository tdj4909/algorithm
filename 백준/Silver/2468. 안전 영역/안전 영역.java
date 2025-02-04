import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] land;
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int result = 0;
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        land = new int[N][N];
        StringTokenizer st;
        for (int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                int n = Integer.parseInt(st.nextToken());
                if (n > max){
                    max = n;
                } else if (n < min) {
                    min = n;
                }
                land[i][j] = n;
            }
        }

        for (int i = min; i <= max; i++){
            int[][] board = new int[N][N];
            int cnt = 0;
            for (int j = 0; j < N; j++){
                for (int k = 0; k < N; k++){
                    if (land[j][k] >= i && board[j][k] == 0) {
                        cnt++;
                        bfs(new int[]{j, k}, i, board, cnt);
                    }
                }
            }
            result = Math.max(result, cnt);
        }
        System.out.println(result);
    }

    static void bfs(int[] start, int h, int[][] board, int cnt){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        board[start[0]][start[1]] = cnt;
        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++){
                int x = curr[0] + dx[i];
                int y = curr[1] + dy[i];

                if (x>=0 && x<N && y>=0 && y<N && land[x][y] >= h && board[x][y] == 0){
                    board[x][y] = cnt;
                    queue.offer(new int[]{x,y});
                }
            }
        }
    }
}