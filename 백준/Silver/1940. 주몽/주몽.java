import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        int l = 0;
        int r = N-1;
        int result = 0;

        while (l < r){
            if (M == list.get(l) + list.get(r)){
                result++;
                l++;
                r--;
            } else if (M < list.get(l) + list.get(r)){
                r--;
            } else {
                l++;
            }
        }

        System.out.println(result);
    }
}