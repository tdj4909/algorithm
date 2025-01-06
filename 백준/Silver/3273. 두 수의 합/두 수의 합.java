import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; stk.hasMoreTokens();i++){
            a.add(Integer.parseInt(stk.nextToken()));
        }
        int x = Integer.parseInt(br.readLine());
        Collections.sort(a);
        int left = 0;
        int right = a.size()-1;
        int result = 0;
        while (left < right){
            if (a.get(left) + a.get(right) > x){
                right--;
            } else if (a.get(left) + a.get(right) < x) {
                left++;
            } else {
                result++;
                left++;
                right--;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}