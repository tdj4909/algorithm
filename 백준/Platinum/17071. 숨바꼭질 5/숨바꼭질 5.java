import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (bfs(N, K)) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
    }

    static boolean bfs(int n, int k) {
        if (n == k) {
            return true;
        }

        boolean[] loc = new boolean[500001];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(k);
        queue.offer(n);
        loc[n] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (curr == k && !loc[curr]) {
                cnt++;
                k += cnt;
                if (k > 500000) {
                    return false;
                }

                queue.offer(k);
            } else {
                loc[curr] = false;

                if (curr != 0) {
                    int next = curr - 1;

                    if (next == k) {
                        return true;
                    } else if (!loc[next]) {
                        loc[next] = true;
                        queue.offer(next);
                    }
                }

                if (curr != 500000) {
                    int next = curr + 1;

                    if (next == k) {
                        return true;
                    } else if (!loc[next]) {
                        loc[next] = true;
                        queue.offer(next);
                    }
                }

                if (curr <= 250000) {
                    int next = curr * 2;

                    if (next == k) {
                        return true;
                    } else if (!loc[next]) {
                        loc[next] = true;
                        queue.offer(next);
                    }
                }

            }
        }

        return false;
    }

}