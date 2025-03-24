import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String d = br.readLine();
        int lenDoc = document.length();
        int lenD = d.length();
        int result = 0;
        int idx = 0;

        while (idx <= lenDoc - lenD){

            boolean b = true;
            for (int i = 0; i < lenD; i++){
                if (document.charAt(idx + i) != d.charAt(i)){
                    b = false;
                    break;
                }
            }

            if (b){
                result++;
                idx += lenD;
            } else {
                idx++;
            }
        }

        System.out.println(result);
    }
}