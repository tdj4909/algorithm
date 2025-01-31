import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<int[]> stack = new Stack<>();
        int[] result = new int[N];
        for (int i = 0; i < N; i++){
            while (!stack.isEmpty() && stack.peek()[0] < A[i]){
                result[stack.pop()[1]] = A[i];
            }
            stack.push(new int[]{A[i], i});
        }
        while (!stack.isEmpty()){
            result[stack.pop()[1]] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int n : result){
            sb.append(n).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}