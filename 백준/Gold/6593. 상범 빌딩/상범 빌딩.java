import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dz = new int[]{1,-1,0,0,0,0};
    static int[] dx = new int[]{0,0,1,-1,0,0};
    static int[] dy = new int[]{0,0,0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0){
                break;
            }

            int[][][] building = new int[L][R][C];
            int[] start = new int[3];
            for (int i = 0; i < L; i++){
                for (int j = 0; j < R; j++){
                    String str = br.readLine();
                    for (int k = 0; k < C; k++){
                        char ch = str.charAt(k);
                        if (ch == 'S'){
                            building[i][j][k] = 1;
                            start = new int[]{i,j,k};
                        } else if (ch == '.') {
                            building[i][j][k] = 0;
                        } else if (ch == '#') {
                            building[i][j][k] = -1;
                        } else if (ch == 'E') {
                            building[i][j][k] = -2;
                        }
                    }
                }
                br.readLine();
            }

            int result = bfs(start, building, L, R, C) - 1;
            if (result == -1){
                System.out.println("Trapped!");
            } else {
                System.out.printf("Escaped in %d minute(s).\n", result);
            }

        }


    }

    static int bfs(int[] start, int[][][] building, int L, int R, int C){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            for (int i = 0; i < 6; i++){
                int z = curr[0] + dz[i];
                int x = curr[1] + dx[i];
                int y = curr[2] + dy[i];

                if (z>=0 && z<L &&
                    x>=0 && x<R &&
                    y>=0 && y<C &&
                    building[z][x][y] == 0){
                    building[z][x][y] = building[curr[0]][curr[1]][curr[2]] + 1;
                    queue.offer(new int[]{z,x,y});
                } else if (z>=0 && z<L &&
                        x>=0 && x<R &&
                        y>=0 && y<C &&
                        building[z][x][y] == -2) {
                    return building[curr[0]][curr[1]][curr[2]] + 1;
                }
            }
        }
        return 0;
    }

}