import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Road implements Comparable<Road>{
    int x;
    int y;
    int dist;

    public Road(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public int compareTo(Road o) {
        return this.dist - o.dist;
    }
}

public class Main {
    static ArrayList<Road> roads;
    static int[] parent;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if (m == 0 && n == 0){
                break;
            }

            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            roads = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                roads.add(new Road(x, y, z));
            }
            Collections.sort(roads);

            result = 0;
            for (Road road : roads) {
                union(road);
            }

            System.out.println(result);
        }
    }

    public static int find(int x){
        if (x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void union(Road road){
        int rootX = find(road.x);
        int rootY = find(road.y);

        if (rootX == rootY){
            result += road.dist;
        } else if (road.x < road.y) {
            parent[rootY] = rootX;
        } else {
            parent[rootX] = rootY;
        }
    }
}