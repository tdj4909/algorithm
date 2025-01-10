import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node>{
    int dist;
    int node;

    public Node(int dist, int node) {
        this.dist = dist;
        this.node = node;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.dist, other.dist);
    }
}

public class Main {
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        distance = new int[V+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i <= V; i++){
            graph.add(new ArrayList<>());
        }


        StringTokenizer st;
        for (int i = 1; i <= V; i++){
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()){
                int n = Integer.parseInt(st.nextToken());
                if (n == -1){
                    break;
                }
                int d = Integer.parseInt(st.nextToken());
                graph.get(node).add(new Node(d,n));
            }
        }

        // 제일 긴 거리 구하기
        dijkstra(1);
        int max = 0;
        int maxIdx = 1;
        for (int i = 1; i <= V; i++){
            if (distance[i] != Integer.MAX_VALUE && distance[i] > max){
                max = distance[i];
                maxIdx = i;
            }
        }

        // 트리의 지름 구하기
        Arrays.fill(distance, Integer.MAX_VALUE);
        dijkstra(maxIdx);
        max = 0;
        for (int i = 1; i <= V; i++){
            if (distance[i] != Integer.MAX_VALUE && distance[i] > max){
                max = distance[i];
            }
        }

        System.out.println(max);
        br.close();
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, start));
        distance[start] = 0;
        while (!pq.isEmpty()){
            Node curr = pq.poll();
            if (curr.dist > distance[curr.node]){
                continue;
            }
            for (Node next : graph.get(curr.node)){
                int cost = curr.dist + next.dist;
                if (distance[next.node] > cost){
                    distance[next.node] = cost;
                    pq.offer(new Node(cost, next.node));
                }
            }
        }
    }
}