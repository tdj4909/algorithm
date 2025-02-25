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

        if (A.length() != B.length()){
            if (A.length() > B.length()){
                int l = A.length()-B.length();
                for (int i = 0; i < l; i++){
                    B = "0" + B;
                }
            } else {
                int l = B.length()-A.length();
                for (int i = 0; i < l; i++){
                    A = "0" + A;
                }
            }
        }

        String result = "";
        for (int i = 0; i < A.length(); i++){
            result = result + String.valueOf(Integer.parseInt(String.valueOf(A.charAt(i))) + Integer.parseInt(String.valueOf(B.charAt(i))));
        }

        System.out.println(result);
    }
}