import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        hanoi(N,1,3);
        System.out.println(cnt);
        System.out.println(sb);
    }

    static void hanoi(int N, int s, int d){
        cnt++;
        if (N == 1){
            sb.append(s + " " + d + "\n");
            return;
        }
        hanoi(N-1,s,6-s-d);
        sb.append(s + " " + d + "\n");
        hanoi(N-1,6-s-d,d);
    }
}