import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int answer = 1;

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == 'A'){
                if (answer == 1){
                    answer = 2;
                } else if (answer == 2) {
                    answer = 1;
                }
            } else if (c == 'B') {
                if (answer == 2){
                    answer = 3;
                } else if (answer == 3) {
                    answer = 2;
                }
            } else {
                if (answer == 1){
                    answer = 3;
                } else if (answer == 3) {
                    answer = 1;
                }
            }
        }

        System.out.println(answer);
    }
}