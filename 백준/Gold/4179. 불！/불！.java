import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] maze;
    static int R;
    static int C;
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static Deque<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        maze = new int[R][C];

        queue = new ArrayDeque<>();
        for (int i = 0; i < R; i++){
            String s = br.readLine();
            for (int j = 0; j < C; j++){
                char ch = s.charAt(j);
                if (ch == 'J'){
                    maze[i][j] = 1;
                    queue.offerFirst(new int[]{i, j});
                } else if (ch == 'F') {
                    maze[i][j] = -2;
                    queue.offerLast(new int[]{i,j});
                } else if (ch == '#') {
                    maze[i][j] = -1;
                } else if (ch == '.') {
                    maze[i][j] = 0;
                }
            }
        }

        int result = bfs();
        if (result == 0){
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }

    }

    static int bfs(){
        while (!queue.isEmpty()){
            int[] loc = queue.pollFirst();

            for (int i = 0; i < 4; i++){
                int x = loc[0] + dx[i];
                int y = loc[1] + dy[i];

                if (maze[loc[0]][loc[1]] == -2){
                    if (x>=0 && x<R && y>=0 && y<C && maze[x][y] >= 0){
                        maze[x][y] = -2;
                        queue.offerLast(new int[]{x,y});
                    }
                } else {
                    if ((x<0 || x>=R || y<0 || y>=C)){
                        return maze[loc[0]][loc[1]];
                    } else {
                        if (maze[x][y] == 0){
                            maze[x][y] = maze[loc[0]][loc[1]] + 1;
                            queue.offerLast(new int[]{x,y});
                        }
                    }
                }
            }
        }
        return 0;
    }
}