import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++){
            String str = br.readLine();
            String[] num = str.split("-");
            int front = 0;
            int rear = Integer.parseInt(num[1]);

            for (int j = 0; j < 3; j++){
                front += (int) ((((int) num[0].charAt(j)) - 65) * Math.pow(26, 2-j));
            }

            if (Math.abs(front-rear) <= 100){
                System.out.println("nice");
            } else {
                System.out.println("not nice");
            }
        }
        br.close();
    }
}