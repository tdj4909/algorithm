import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0){
            String[] list = br.readLine().split(" ");
            for (int i = 2; i < list.length; i++){
                System.out.print(list[i] + " ");
            }
            System.out.print(list[0] + " ");
            System.out.println(list[1]);
        }
    }
}