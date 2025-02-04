import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++){
            String s = br.readLine();
            for (int j = 0; j < M; j++){
                map[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        int[][][] dist = new int[N][M][2];
        bfs(dist, N, M);

        if (dist[N-1][M-1][0] == 0 && dist[N-1][M-1][1] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(Math.max(dist[N-1][M-1][0], dist[N-1][M-1][1]));
        }

    }

    static void bfs(int[][][] dist, int N, int M){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0,0});
        dist[0][0] = new int[]{1,0};
        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            
            for (int i = 0; i < 4; i++){
                int x = curr[0] + dx[i];
                int y = curr[1] + dy[i];

                if (x<0 || x>=N || y<0 || y>=M){
                    continue;
                }

                if (map[x][y] == 1 && dist[curr[0]][curr[1]][0] != 0 && dist[x][y][1] == 0) {

                    dist[x][y][1] = dist[curr[0]][curr[1]][0] + 1;

                    if (x == N-1 && y == M-1){
                        return;
                    }
                    queue.offer(new int[]{x,y});
                } else if (map[x][y] == 0 && (dist[x][y][0] == 0 || dist[x][y][1] == 0)){

                    if (dist[curr[0]][curr[1]][1] != 0 && dist[x][y][1] == 0){
                        dist[x][y][1] = dist[curr[0]][curr[1]][1] + 1;
                        if (x == N-1 && y == M-1){
                            return;
                        }
                        queue.offer(new int[]{x,y});
                    } else if(dist[curr[0]][curr[1]][0] != 0 && dist[x][y][0] == 0){
                        dist[x][y][0] = dist[curr[0]][curr[1]][0] + 1;
                        if (x == N-1 && y == M-1){
                            return;
                        }
                        queue.offer(new int[]{x,y});
                    }

                }

            }
        }
    }

}