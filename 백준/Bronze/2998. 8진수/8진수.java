import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = s.length();

        if (len % 3 == 1){
            s = "00" + s;
        } else if (len % 3 == 2){
            s = "0" + s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += 3){
            sb.append(Integer.parseInt(s.substring(i,i+3),2));
        }

        System.out.println(sb.toString());
    }
}