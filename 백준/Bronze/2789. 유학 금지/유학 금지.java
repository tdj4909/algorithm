import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String cam = "CAMBRIDGE";

        for (int i = 0; i < str.length(); i++){
            for (int j = 0; j < cam.length(); j++){
                if (str.charAt(i) == cam.charAt(j)){
                    str = str.substring(0,i) + " " + str.substring(i+1);
                }
            }
        }

        System.out.println(str.replaceAll(" ", ""));
    }
}