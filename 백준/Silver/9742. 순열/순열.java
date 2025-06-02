import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringTokenizer st;
        while ((s = br.readLine()) != null){
            st = new StringTokenizer(s);
            String o = st.nextToken();
            int n = Integer.parseInt(st.nextToken());

            char[] arr = o.toCharArray();
            int cnt = 1;
            boolean flag = false;
            while (true){
                if (cnt == n){
                    flag = true;
                    break;
                }
                boolean chg = false;

                for (int i = arr.length-1; i > 0; i--){
                    if (arr[i] > arr[i-1]){
                        int min = i;
                        for (int j = arr.length-1; j >= i; j--){
                            if (arr[i-1] < arr[j] && arr[min] > arr[j]){
                                min = j;
                            }
                        }

                        char tmp = arr[i-1];
                        arr[i-1] = arr[min];
                        arr[min] = tmp;
                        Arrays.sort(arr, i, arr.length);
                        chg = true;
                        cnt++;
                        break;
                    }
                }

                if (!chg){
                    break;
                }
            }

            if (flag) {
                System.out.println(o + " " + n + " = " + String.valueOf(arr));
            } else {
                System.out.println(o + " " + n + " = No permutation");
            }
        }
    }
}