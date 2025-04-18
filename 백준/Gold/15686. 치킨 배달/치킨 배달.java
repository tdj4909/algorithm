import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int hs;
    static int cs;
    static int[][] dist;
    static boolean[] select;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        ArrayList<int[]> house = new ArrayList<>();
        ArrayList<int[]> chicken = new ArrayList<>();

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                if (n == 1){
                    house.add(new int[]{i,j});
                } else if (n == 2) {
                    chicken.add(new int[]{i,j});
                }
            }
        }

        hs = house.size();
        cs = chicken.size();
        dist = new int[hs][cs];
        select = new boolean[cs];

        for (int i = 0; i < hs; i++){
            int[] pos = house.get(i);
            for (int j = 0; j < cs; j++){
                dist[i][j] = Math.abs(pos[0] - chicken.get(j)[0]) + Math.abs(pos[1] - chicken.get(j)[1]);
            }
        }

        bt(0, 0);

        System.out.println(result);
    }

    public static void bt(int d, int s){
        if (d == M){
            int totalDistSum = 0;
            for (int i = 0; i < hs; i++){
                int distSum = Integer.MAX_VALUE;
                for (int j = 0; j < cs; j++) {
                    if (select[j]) {
                        distSum = Math.min(distSum, dist[i][j]);
                    }
                }
                totalDistSum += distSum;
            }

            result = Math.min(result, totalDistSum);
            return;
        }

        for (int i = s; i < cs; i++){
            if (!select[i]){
                select[i] = true;
                bt(d+1,i+1);
                select[i] = false;
            }
        }
    }
}