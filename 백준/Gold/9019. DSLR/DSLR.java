import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bw.write(bfs(A,B).substring(1)+"\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }

    static String bfs(int start, int end){
        Deque<String> deque = new ArrayDeque<>();
        deque.addLast(String.valueOf(start) + " .");
        boolean[] visited = new boolean[10001];
        int n;
        int tmpN;
        String result = "";
        String tmpS;
        while (!deque.isEmpty()){
            st = new StringTokenizer(deque.pollFirst());
            n = Integer.parseInt(st.nextToken());
            result = st.nextToken();

            if (n == end){
                return result;
            }

            tmpN = (2 * n) % 10000;
            if (!visited[tmpN]) {
                visited[tmpN] = true;
                tmpS = String.valueOf(tmpN) + " " + result + "D";
                deque.addLast(tmpS);
            }

            if (n == 0){
                tmpN = 9999;
                if (!visited[tmpN]) {
                    visited[tmpN] = true;
                    tmpS = String.valueOf(tmpN) + " " + result + "S";
                    deque.addLast(tmpS);
                }
            } else {
                tmpN = n-1;
                if (!visited[tmpN]) {
                    visited[tmpN] = true;
                    tmpS = String.valueOf(tmpN) + " " + result + "S";
                    deque.addLast(tmpS);
                }
            }

            tmpN = ((n - ((n /1000) * 1000))*10) + (n/ 1000);
            if (!visited[tmpN]) {
                visited[tmpN] = true;
                tmpS = String.valueOf(tmpN) + " " + result + "L";
                deque.addLast(tmpS);
            }

            tmpN = (n / 10) + ((n % 10) * 1000);
            if (!visited[tmpN]) {
                visited[tmpN] = true;
                tmpS = String.valueOf(tmpN) + " " + result + "R";
                deque.addLast(tmpS);
            }
        }
        return result;
    }
}