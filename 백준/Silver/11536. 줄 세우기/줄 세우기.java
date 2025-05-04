import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++){
            arr[i] = br.readLine();
        }

        String[] Oarr = arr.clone();
        Arrays.sort(arr);
        String[] Iarr = arr.clone();
        Arrays.sort(arr, Collections.reverseOrder());
        String[] Darr = arr.clone();

        boolean Ib = true;
        boolean Db = true;

        for (int i = 0; i < N; i++){
            if (Ib && !Oarr[i].equals(Iarr[i])){
                Ib = false;
            }
            if (Db && !Oarr[i].equals(Darr[i])) {
                Db = false;
            }
            if (!Ib && !Db){
                break;
            }
        }

        if (Ib){
            System.out.println("INCREASING");
        } else if (Db) {
            System.out.println("DECREASING");
        } else {
            System.out.println("NEITHER");
        }
    }
}