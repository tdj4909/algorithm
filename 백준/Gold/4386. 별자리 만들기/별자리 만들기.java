import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Coordinate{
    double x;
    double y;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge>{
    int start;
    int end;
    double weight;

    public Edge(int start, int end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public int compareTo(Edge o) {
        return (int) (this.weight - o.weight);
    }
}

public class Main {
    static ArrayList<Coordinate> coordinates;
    static ArrayList<Edge> edges;
    static int[] parent;
    static double result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[][] weight = new double[n][n];
        result = 0.0;

        coordinates = new ArrayList<>();
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            coordinates.add(new Coordinate(x, y));
        }

        edges = new ArrayList<>();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i == j){
                    continue;
                }
                edges.add(new Edge(i, j, calWeight(coordinates.get(i), coordinates.get(j))));
            }
        }
        Collections.sort(edges);

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (Edge edge : edges){
            union(edge);
        }

        System.out.printf("%.2f%n", result);
    }

    public static double calWeight(Coordinate coordinate1, Coordinate coordinate2){
        return Math.sqrt(Math.pow((coordinate1.x - coordinate2.x), 2) + Math.pow((coordinate1.y - coordinate2.y), 2));
    }

    public static int find(int x){
        if (x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void union(Edge edge){
        int rootX = find(edge.start);
        int rootY = find(edge.end);

        if (rootX == rootY){
            return;
        } else if (edge.start < edge.end) {
            parent[rootY] = rootX;
            result += edge.weight;
        } else {
            parent[rootX] = rootY;
            result += edge.weight;
        }
    }
}