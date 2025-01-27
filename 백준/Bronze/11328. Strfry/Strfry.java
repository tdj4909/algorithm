import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();

            int[] ch = new int[26];
            for (int j = 0; j < str1.length(); j++){
                ch[str1.charAt(j) - 'a']++;
            }

            boolean flag = true;
            for (int j = 0; j < str2.length(); j++){
                if (ch[str2.charAt(j) - 'a'] == 0){
                    flag = false;
                    break;
                } else {
                    ch[str2.charAt(j) - 'a']--;
                }
            }

            if (str2.length() != str1.length()){
                flag = false;
            }

            if (flag){
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }

        br.close();
    }
}