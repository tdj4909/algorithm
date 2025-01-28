import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        String str = br.readLine();
        int resultJ = 0;
        int resultI = 0;

        for (int i = 0; i < str.length()-2; i++){
            if (str.charAt(i) == 'J' && str.charAt(i+1) == 'O' && str.charAt(i+2) == 'I'){
                resultJ++;
            }
            if (str.charAt(i) == 'I' && str.charAt(i+1) == 'O' && str.charAt(i+2) == 'I'){
                resultI++;
            }
        }

        System.out.println(resultJ);
        System.out.println(resultI);

        br.close();
    }
}