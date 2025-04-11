import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S;

        while (!(S = br.readLine()).equals("0")){
            System.out.print(S + " ");

            while (S.length() != 1){
                int tmp = 1;
                for (int i = 0; i < S.length(); i++){
                    tmp *= Integer.parseInt(String.valueOf(S.charAt(i)));
                }
                S = String.valueOf(tmp);
                System.out.print(S + " ");
            }

            System.out.println();
        }

    }
}