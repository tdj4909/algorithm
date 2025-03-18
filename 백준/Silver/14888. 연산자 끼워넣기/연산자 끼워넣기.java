import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] A;
    static int[] operator;
    static int[] visited = new int[4];;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[st.countTokens()];
        for (int i = 0; i < A.length; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        operator = new int[4];
        for (int i = 0; i < operator.length; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(A[0]);
        bt(1, stack);

        System.out.println(max);
        System.out.println(min);
    }

    static void bt(int n, Stack<Integer> s){
        if (n == N){
            int total = s.peek();

            max = Math.max(max, total);
            min = Math.min(min, total);

            return;
        }

        for (int i = 0; i < 4; i++){
            if (operator[i] > visited[i]){
                visited[i]++;
                int tmp = s.pop();
                if (i == 0){
                    s.push(tmp+A[n]);
                } else if (i == 1) {
                    s.push(tmp-A[n]);
                } else if (i == 2) {
                    s.push(tmp*A[n]);
                } else {
                    s.push(tmp/A[n]);
                }

                bt(n+1,s);

                visited[i]--;
                s.pop();
                s.push(tmp);
            }
        }
    }

}