import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Loc{
    int x;
    int y;
    int num;

    public Loc(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Loc{" +
                "x=" + x +
                ", y=" + y +
                ", num=" + num +
                '}';
    }
}

class Dist implements Comparable<Dist>{
    Loc loc1;
    Loc loc2;
    int dist;

    public Dist(Loc loc1, Loc loc2, int dist) {
        this.loc1 = loc1;
        this.loc2 = loc2;
        this.dist = dist;
    }

    @Override
    public int compareTo(Dist o) {
        return this.dist - o.dist;
    }
}

public class Main {
    static ArrayList<Loc> locs;
    static ArrayList<Dist> dists;
    static int[] parent;
    static int result;
    static int resultCnt;
    static int N;
    static int M;
    static int[][] board;
    static int cnt;
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = 1;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (board[i][j] == 1){
                    bfs(i, j);
                }
            }
        }

        locs = new ArrayList<>();
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (board[i][j] != 0) {
                    locs.add(new Loc(i, j, board[i][j]));
                }
            }
        }
        int size = 0;
        for (Loc loc : locs){
            size = Math.max(size, loc.num);
        }
        parent = new int[size + 1];
        for (int i = 2; i <= size; i++){
            parent[i] = i;
        }

        dists = new ArrayList<>();
        for (int i = 0; i < locs.size(); i++){
            for (int j = i + 1; j < locs.size(); j++){
                if (locs.get(i).num != locs.get(j).num && (locs.get(i).x == locs.get(j).x || locs.get(i).y == locs.get(j).y)){
                    if (locs.get(i).x == locs.get(j).x){
                        dists.add(new Dist(locs.get(i), locs.get(j), Math.abs(locs.get(i).y - locs.get(j).y)-1));
                    } else {
                        dists.add(new Dist(locs.get(i), locs.get(j), Math.abs(locs.get(i).x - locs.get(j).x)-1));
                    }
                }

            }
        }

        Collections.sort(dists);

        result = 0;
        resultCnt = 0;
        for (Dist dist : dists){
            union(dist);
        }

        if (resultCnt == cnt - 2) {
            System.out.println(result == 0 ? -1 : result);
        } else {
            System.out.println(-1);
        }
    }

    public static void bfs(int x, int y){
        cnt++;
        Queue<Loc> queue = new ArrayDeque<>();
        queue.offer(new Loc(x,y,cnt));
        board[x][y] = cnt;
        while (!queue.isEmpty()){
            Loc currLoc = queue.poll();

            for (int i = 0; i < 4; i++){
                int nx = currLoc.x + dx[i];
                int ny = currLoc.y + dy[i];

                if (0<=nx && nx<N && 0<=ny && ny<M && board[nx][ny] == 1){
                    board[nx][ny] = cnt;
                    queue.offer(new Loc(nx, ny, cnt));
                }
            }
        }
    }

    public static int find(int x){
        if (x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void union(Dist dist){
        if (dist.dist < 2){
            return;
        }
        boolean check = true;
        int rootX = find(dist.loc1.num);
        int rootY = find(dist.loc2.num);

        if (rootX == rootY){
            return;
        } else if (dist.loc1.num < dist.loc2.num) {
            if (dist.loc1.x == dist.loc2.x){
                for (int i = Math.min(dist.loc1.y, dist.loc2.y) + 1; i < Math.max(dist.loc1.y, dist.loc2.y); i++){
                    if (board[dist.loc1.x][i] != 0){
                        check = false;
                        break;
                    }
                }
                if (check){
                    parent[rootY] = rootX;
                    result += dist.dist;
                    resultCnt++;
                }
            } else {
                for (int i = Math.min(dist.loc1.x, dist.loc2.x) + 1; i < Math.max(dist.loc1.x, dist.loc2.x); i++){
                    if (board[i][dist.loc1.y] != 0){
                        check = false;
                        break;
                    }
                }
                if (check){
                    parent[rootY] = rootX;
                    result += dist.dist;
                    resultCnt++;
                }
            }
        } else {
            if (dist.loc1.x == dist.loc2.x){
                for (int i = Math.min(dist.loc1.y, dist.loc2.y) + 1; i < Math.max(dist.loc1.y, dist.loc2.y); i++){
                    if (board[dist.loc1.x][i] != 0){
                        check = false;
                        break;
                    }
                }
                if (check){
                    parent[rootX] = rootY;
                    result += dist.dist;
                    resultCnt++;
                }
            } else {
                for (int i = Math.min(dist.loc1.x, dist.loc2.x) + 1; i < Math.max(dist.loc1.x, dist.loc2.x); i++){
                    if (board[i][dist.loc1.y] != 0){
                        check = false;
                        break;
                    }
                }
                if (check){
                    parent[rootX] = rootY;
                    result += dist.dist;
                    resultCnt++;
                }
            }
        }
    }
}