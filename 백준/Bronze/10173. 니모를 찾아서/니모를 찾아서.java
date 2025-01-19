import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String str = br.readLine();
            if (str.equals("EOI")){
                break;
            }
            str = str.toUpperCase();

            if (str.contains("NEMO")) {
                System.out.println("Found");
            } else {
                System.out.println("Missing");
            }
        }

        br.close();
    }
}