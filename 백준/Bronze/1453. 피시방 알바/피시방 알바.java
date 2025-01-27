import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] nums = new boolean[101];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;

        for (int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());

            if (nums[num]){
                result++;
            } else {
                nums[num] = true;
            }
        }

        System.out.println(result);
        br.close();
    }
}