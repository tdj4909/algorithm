import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] map;
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++){
            String s = br.readLine();
            for (int j = 0; j < M; j++){
                if (s.charAt(j) == '0'){
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;
                }
            }
        }

        if (bfs()){
            System.out.println(map[N-1][M-1]);
        } else {
            System.out.println(-1);
        }

    }

    static boolean bfs(){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0,0,0});
        int[][][] visited = new int[N][M][K+1];
        visited[0][0][0] = 1;

        if (N==1 && M==1){
            map[N-1][M-1] = visited[0][0][0];
            return true;
        }

        while (!queue.isEmpty()){
            int[] curr = queue.poll();

            for (int i = 0; i < 4; i++){
                int x = curr[0] + dx[i];
                int y = curr[1] + dy[i];

                if (x<0 || x>=N || y<0 || y>=M){
                    continue;
                }

                if (map[x][y] == 0 && visited[x][y][curr[2]] == 0){
                    visited[x][y][curr[2]] = visited[curr[0]][curr[1]][curr[2]] + 1;

                    if (x == N-1 && y == M-1){
                        map[x][y] = visited[x][y][curr[2]];
                        return true;
                    }
                    queue.offer(new int[]{x,y,curr[2]});

                } else if (map[x][y] == 1 && curr[2] < K && visited[x][y][curr[2]+1] == 0) {
                    visited[x][y][curr[2]+1] = visited[curr[0]][curr[1]][curr[2]] + 1;

                    if (x == N-1 && y == M-1){
                        map[x][y] = visited[x][y][curr[2]+1];
                        return true;
                    }
                    queue.offer(new int[]{x,y,curr[2]+1});

                }
            }
        }

        return false;
    }

}