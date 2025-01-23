import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[] arr, tree;
    static int mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        for (int i = 1; i <= N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        tree = new long[N*4+1];
        Arrays.fill(tree,1);
        build(1,N,1);

        for (int i = 0; i < M+K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1){
                update(1,N,1,b,c);
            } else {
                System.out.println(query(1,N,1,b,c) % mod);
            }
        }

        br.close();
    }

    static void build(int start, int end, int node){
        if (start == end){
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end)/2;
        build(start, mid, node*2);
        build(mid+1, end, node*2+1);

        tree[node] = (tree[node*2]%mod * tree[node*2+1]%mod)%mod;
    }

    static void update(int start, int end, int node, int idx, int value){
        if (idx < start || idx > end){
            return;
        }
        if (start == end){
            tree[node] = value;
            return;
        }

        int mid = (start+end)/2;
        update(start,mid,node*2,idx,value);
        update(mid+1, end, node*2+1,idx,value);

        tree[node] = (tree[node*2]%mod * tree[node*2+1]%mod)%mod;
    }

    static long query(int start, int end, int node, int left, int right){
        if (right < start || left > end){
            return 1;
        }
        if (left <= start && right >= end){
            return tree[node];
        }

        int mid = (start+end)/2;
        long leftMul = query(start,mid,node*2,left,right);
        long rightMul = query(mid+1, end, node*2+1,left,right);

        return (leftMul%mod * rightMul%mod)%mod;
    }
}