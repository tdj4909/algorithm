import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Coordinate{
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Dist implements Comparable<Dist>{
    int a;
    int b;
    double dist;

    public Dist(int a, int b, double dist) {
        this.a = a;
        this.b = b;
        this.dist = dist;
    }

    @Override
    public int compareTo(Dist o) {
        return (int) Math.floor(this.dist - o.dist);
    }

}
public class Main {
    static ArrayList<Coordinate> coordinates;
    static ArrayList<Dist> dists;
    static int[] parent;
    static double result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        result = 0.00;

        parent = new int[N];
        for (int i = 0; i < N; i++){
            parent[i] = i;
        }

        coordinates = new ArrayList<>();
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            coordinates.add(new Coordinate(X, Y));
        }

        dists = new ArrayList<>();
        for (int i = 0; i < N; i++){
            for (int j = i + 1; j < N; j++){
                dists.add(new Dist(i, j, cal(coordinates.get(i), coordinates.get(j))));
            }
        }
        Collections.sort(dists);

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            X--;
            Y--;

            Dist dist = new Dist(X, Y, 0.0);
            union(dist);
        }
        result = 0.00;

        for (Dist dist : dists){
            union(dist);
        }

        System.out.printf("%.2f", result);
    }

    public static double cal(Coordinate c1, Coordinate c2){
        return Math.sqrt(Math.pow(c1.x - c2.x, 2) + Math.pow(c1.y - c2.y, 2));
    }

    public static int find(int x){
        if (x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public static void union(Dist dist){
        int rootX = find(dist.a);
        int rootY = find(dist.b);

        if (rootX == rootY){
            return;
        } else if (dist.a < dist.b) {
            parent[rootY] = rootX;
            result += dist.dist;
        } else {
            parent[rootX] = rootY;
            result += dist.dist;
        }
    }
}