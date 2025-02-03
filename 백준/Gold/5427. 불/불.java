import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] maze;
    static int w;
    static int h;
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static Deque<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            maze = new int[h][w];

            queue = new ArrayDeque<>();
            for (int j = 0; j < h; j++) {
                String s = br.readLine();
                for (int k = 0; k < w; k++) {
                    char ch = s.charAt(k);
                    if (ch == '@') {
                        maze[j][k] = 1;
                        queue.offerFirst(new int[]{j, k});
                    } else if (ch == '*') {
                        maze[j][k] = -2;
                        queue.offerLast(new int[]{j, k});
                    } else if (ch == '#') {
                        maze[j][k] = -1;
                    } else if (ch == '.') {
                        maze[j][k] = 0;
                    }
                }
            }

            int result = bfs();
            if (result == 0) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }
        }
    }

    static int bfs(){
        while (!queue.isEmpty()){
            int[] loc = queue.pollFirst();

            for (int i = 0; i < 4; i++){
                int x = loc[0] + dx[i];
                int y = loc[1] + dy[i];

                if (maze[loc[0]][loc[1]] == -2){
                    if (x>=0 && x<h && y>=0 && y<w && maze[x][y] >= 0){
                        maze[x][y] = -2;
                        queue.offerLast(new int[]{x,y});
                    }
                } else {
                    if ((x<0 || x>=h || y<0 || y>=w)){
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