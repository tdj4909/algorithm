import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int happy = 0;
        int sad = 0;

        if (s.length() >= 3) {
            for (int i = 0 ; i < s.length()-2; i++){
                if (s.charAt(i) == ':'
                    && s.charAt(i+1) == '-'
                    && s.charAt(i+2) == ')'){
                    happy++;
                } else if (s.charAt(i) == ':'
                        && s.charAt(i+1) == '-'
                        && s.charAt(i+2) == '(') {
                    sad++;
                }
            }
        }

        if (happy == 0 && sad == 0){
            System.out.println("none");
        } else if (happy == sad) {
            System.out.println("unsure");
        } else if (happy > sad) {
            System.out.println("happy");
        } else {
            System.out.println("sad");
        }
    }
}