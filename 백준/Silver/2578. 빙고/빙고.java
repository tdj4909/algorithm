import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] map = new int[25];
        boolean[] selected = new boolean[25];
        StringTokenizer st;
        for (int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++){
                map[Integer.parseInt(st.nextToken())-1] = i*5 + j;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(br.readLine());
        for (int i = 0; i < 4; i++){
            sb.append(" ").append(br.readLine());
        }

        boolean flag = false;
        int result = 0;
        st = new StringTokenizer(sb.toString());
        for (int i = 1; i <= 25; i++){
            int n = Integer.parseInt(st.nextToken())-1;
            selected[map[n]] = true;

            if (i >= 12){
                flag = searchBingo(selected);
            }

            if (flag){
                result = i;
                break;
            }
        }

        System.out.println(result);
    }

    static boolean searchBingo(boolean[] selected){
        int cnt = 0;
        // 가로
        for (int i = 0; i < 5; i++){
            boolean flag = true;
            for (int j = 0; j < 5; j++){
                if (!selected[i*5 + j]){
                    flag = false;
                    break;
                }
            }
            if (flag){
                cnt++;
            }
        }
        // 세로
        for (int i = 0; i < 5; i++){
            boolean flag = true;
            for (int j = 0; j < 5; j++){
                if (!selected[i + j*5]){
                    flag = false;
                    break;
                }
            }
            if (flag){
                cnt++;
            }
        }
        // 대각선
        boolean flag = true;
        for (int i = 0; i < 5; i++){
            if (!selected[i*6]){
                flag = false;
                break;
            }
        }
        if (flag){
            cnt++;
        }

        flag = true;
        for (int i = 0; i < 5; i++){
            if (!selected[4 + i*4]){
                flag = false;
                break;
            }
        }
        if (flag){
            cnt++;
        }


        if (cnt >= 3){
            return true;
        } else {
            return false;
        }
    }
}