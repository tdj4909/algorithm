import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (Integer i : arr){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}