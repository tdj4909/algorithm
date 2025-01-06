import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int S = Integer.parseInt(stk.nextToken());

        ArrayList<Integer> arr = new ArrayList<Integer>();
        stk = new StringTokenizer(br.readLine());
        arr.add(0);
        for (int i = 0; i < N; i++){
            arr.add(Integer.parseInt(stk.nextToken()));
        }
        // 누적 합
        for (int i = 1; i < arr.size(); i++){
            arr.set(i, arr.get(i) + arr.get(i-1));
        }
        int left = 0;
        int right = 1;
        int result = Integer.MAX_VALUE;
        while (right < arr.size()){
            if (arr.get(right) - arr.get(left) >= S){
                result = Math.min(result, right-left);
                left++;

            } else if (arr.get(right) - arr.get(left) < S) {
                right++;
            }
        }
        if (result == Integer.MAX_VALUE){
            bw.write(String.valueOf(0));
        } else {
            bw.write(String.valueOf(result));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}