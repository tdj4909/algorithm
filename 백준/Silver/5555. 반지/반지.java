import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        while (N-- > 0){
            String ring = br.readLine();

            for (int i = 0; i < 10; i++){
                boolean b = false;
                for (int j = 0; j < s.length(); j++){
                    if (i+j>=10){
                        if (s.charAt(j) == ring.charAt(i+j-10)){
                            b = true;
                        } else {
                            b = false;
                            break;
                        }
                    } else {
                        if (s.charAt(j) == ring.charAt(i+j)){
                            b = true;
                        } else {
                            b = false;
                            break;
                        }
                    }
                }
                if (b){
                    result++;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}