import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] room;
    static int[] dx = new int[]{-1,0,1,0};
    static int[] dy = new int[]{0,1,0,-1};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        room = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r,c,d);
        System.out.println(result);
    }

    static void clean(int r, int c, int d){
        if (room[r][c] == 0){
            room[r][c] = -1;
            result++;
        }

        boolean empty = false;
        for (int i = 0; i < 4; i++){
            int nx = r + dx[i];
            int ny = c + dy[i];

            if (room[nx][ny] == 0){
                empty = true;
                break;
            }
        }

        if (empty){
            for (int i = 0; i < 4; i++){
                d--;
                if (d == -1){
                    d = 3;
                }

                int nx = r + dx[d];
                int ny = c + dy[d];
                if (room[nx][ny] == 0) {
                    clean(nx, ny, d);
                    break;
                }
            }
        } else {
            int nd = d + 2;
            if (nd > 3){
                nd -= 4;
            }

            int nx = r + dx[nd];
            int ny = c + dy[nd];
            if (room[nx][ny] != 1) {
                clean(nx, ny, d);
            }

        }
    }

}