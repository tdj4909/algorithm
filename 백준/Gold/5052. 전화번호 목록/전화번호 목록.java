import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            String[] str = new String[n];
            for (int i = 0; i < n; i++){
                str[i] = br.readLine();
            }

            Arrays.sort(str);

            boolean result = true;
            for (int i = 0; i < n-1; i++){
                int len = str[i].length();
                if (str[i+1].length()>=len && str[i+1].substring(0,len).equals(str[i])){
                    result = false;
                    break;
                }
            }

            if (result){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}