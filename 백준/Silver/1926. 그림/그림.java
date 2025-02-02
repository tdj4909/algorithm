import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashMap<Integer, Integer> picture;
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static int cnt = 1;
    static int[][] board;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        picture = new HashMap<>();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (board[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        if (cnt == 1){
            System.out.println(0);
            System.out.println(0);
        } else {
            System.out.println(Collections.max(picture.keySet()) - 1);
            System.out.println(Collections.max(picture.values()));
        }
    }

    static void bfs(int x, int y){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x,y});
        cnt++;
        board[x][y] = cnt;
        picture.put(cnt, 1);

        while (!queue.isEmpty()){
            int[] loc = queue.poll();
            for (int i = 0; i < 4; i++){
                int nx = loc[0] + dx[i];
                int ny = loc[1] + dy[i];

                if (nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny] == 1){
                    board[nx][ny] = cnt;
                    picture.replace(cnt, picture.get(cnt)+1);

                    queue.offer(new int[]{nx,ny});
                }
            }
        }
    }
}