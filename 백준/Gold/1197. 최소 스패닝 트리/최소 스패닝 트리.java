import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int start;
    int end;
    int weight;

    public Node(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}

public class Main {
    static ArrayList<Node> vertex;
    static int[] parent;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        for (int i = 1 ; i <= V; i++){
            parent[i] = i;
        }

        vertex = new ArrayList<>();
        for (int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            vertex.add(new Node(a, b, c));
        }

        Collections.sort(vertex);

        result = 0;
        for (int i = 0; i < E; i++){
            union(vertex.get(i));
        }

        System.out.println(result);
    }

    public static int find(int x){
        if (x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void union(Node node){
        int rootS = find(node.start);
        int rootE = find(node.end);
        
        if (rootS == rootE){
            return;
        } else if (node.start < node.end) {
            parent[rootE] = rootS;
            result += node.weight;
        } else {
            parent[rootS] = rootE;
            result += node.weight;
        }
    }
}