import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] minNum;
    static int[] maxNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        for (int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        minNum = new int[N*4+1];
        maxNum = new int[N*4+1];
        minBuild(1,N,1);
        maxBuild(1,N,1);

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(minQuery(1,N,1,a,b) + " " + maxQuery(1,N,1,a,b));
        }

        br.close();
    }

    static void minBuild(int start, int end, int node){
        if (start == end){
            minNum[node] = arr[start];
            return;
        }

        int mid = (start+end)/2;
        minBuild(start,mid,node*2);
        minBuild(mid+1, end,node*2+1);

        minNum[node] = Math.min(minNum[node*2], minNum[node*2+1]);
    }

    static void maxBuild(int start, int end, int node){
        if (start == end){
            maxNum[node] = arr[start];
            return;
        }

        int mid = (start+end)/2;
        maxBuild(start,mid,node*2);
        maxBuild(mid+1, end,node*2+1);

        maxNum[node] = Math.max(maxNum[node*2], maxNum[node*2+1]);
    }

    static int minQuery(int start, int end, int node, int left, int right){
        if (right < start || left > end) {
            return Integer.MAX_VALUE;
        }

        if (left <= start && right >= end){
            return minNum[node];
        }

        int mid = (start+end)/2;
        int leftMin = minQuery(start, mid, node*2, left, right);
        int rightMin = minQuery(mid+1, end, node*2+1, left, right);

        return Math.min(leftMin,rightMin);
    }

    static int maxQuery(int start, int end, int node, int left, int right){
        if (right < start || left > end) {
            return Integer.MIN_VALUE;
        }

        if (left <= start && right >= end){
            return maxNum[node];
        }

        int mid = (start+end)/2;
        int leftMax = maxQuery(start, mid, node*2, left, right);
        int rightMax = maxQuery(mid+1, end, node*2+1, left, right);

        return Math.max(leftMax,rightMax);
    }
}