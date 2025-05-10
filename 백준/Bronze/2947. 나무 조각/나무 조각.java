import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean flag = true;
        int tmp;

        while (flag){
            flag = false;
            for (int i = 0; i < 4; i++){
                if (arr[i] > arr[i+1]){
                    tmp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = tmp;
                    for (int a : arr){
                        System.out.print(a + " ");
                    }
                    System.out.println();
                }
            }

            for (int i = 0; i < 4; i++){
                if (arr[i] > arr[i+1]){
                    flag = true;
                    break;
                }
            }
        }
    }
}