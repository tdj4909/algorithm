import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        int result = Integer.MAX_VALUE;
        if (A.length() > B.length()){
            for (int i = 0; i <= A.length()-B.length(); i++){
                int tmp = 0;
                for (int j = 0; j < B.length(); j++){
                    if (A.charAt(i+j) != B.charAt(j)){
                        tmp++;
                    }
                }
                result = Math.min(result, tmp);
            }
        } else {
            for (int i = 0; i <= B.length()-A.length(); i++){
                int tmp = 0;
                for (int j = 0; j < A.length(); j++){
                    if (B.charAt(i+j) != A.charAt(j)){
                        tmp++;
                    }
                }
                result = Math.min(result, tmp);
            }
        }
        System.out.println(result);
    }
}