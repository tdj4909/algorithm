import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] list = new char[]{'a','e','i','o','u'};
        String s;
        while (!(s = br.readLine()).equals("#")){
            boolean flag = false;

            for (int i = 0; i < s.length(); i++){
                for (int j = 0; j < 5; j++){
                    if (s.charAt(i) == list[j]){
                        s = s.substring(i) + s.substring(0, i);
                        flag = true;
                        break;
                    }
                }
                if (flag){
                    break;
                }
            }
            s += "ay";
            System.out.println(s);
        }

    }
}