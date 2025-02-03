import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] board;
    static int cnt = 0;
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static int M;
    static int N;
    static HashMap<Integer, Integer> area = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        board = new int[M][N];
        for (int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++){
                for (int k = x1; k < x2; k++){
                    board[j][k] = -1;
                }
            }
        }

        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                if (board[i][j] == 0){
                    cnt++;
                    bfs(new int[]{i,j});
                }
            }
        }

        System.out.println(cnt);
        ArrayList<Integer> result = new ArrayList<>();
        for (int n : area.values()){
            result.add(n);
        }
        Collections.sort(result);

        for (int n : result){
            System.out.print(n + " ");
        }

    }

    static void bfs(int[] start){
        Queue<int[]> queue = new ArrayDeque<>();
        board[start[0]][start[1]] = cnt;
        queue.offer(start);
        area.put(cnt, 1);
        while (!queue.isEmpty()){
            int[] curr = queue.poll();

            for (int i = 0; i < 4; i++){
                int x = curr[0] + dx[i];
                int y = curr[1] + dy[i];

                if (x>=0 && x<M && y>=0 && y<N && board[x][y] == 0){
                    board[x][y] = cnt;
                    area.replace(cnt, area.get(cnt)+1);
                    queue.offer(new int[]{x,y});
                }
            }
        }
    }
}