import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        if ((arr[1] - arr[0]) == (arr[N-1] - arr[N-2])){
            System.out.println(arr[N-1] + (arr[N-1] - arr[N-2]));
        } else {
            System.out.println(arr[N-1] * (arr[N-1] / arr[N-2]));
        }

    }
}