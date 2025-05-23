import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[]{a,b,c};
        Arrays.sort(arr);
        String seq = br.readLine();

        for (int i = 0; i < 3; i++){
            if (seq.charAt(i) == 'A'){
                System.out.print(arr[0] + " ");
            } else if (seq.charAt(i) == 'B') {
                System.out.print(arr[1] + " ");
            } else if (seq.charAt(i) == 'C') {
                System.out.print(arr[2] + " ");
            }
        }

    }
}