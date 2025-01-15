import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int day = y - 1;
        while (x-- != 0){
            if (x == 1 || x == 3 || x == 5 || x == 7 || x == 8 || x == 10 || x == 12){
                day += 31;
            } else if (x == 4 || x == 6 || x == 9 || x == 11) {
                day += 30;
            } else {
                day += 28;
            }
        }

        day %= 7;
        if (day == 0){
            System.out.println("Thursday");
        } else if (day == 1) {
            System.out.println("Friday");
        } else if (day == 2) {
            System.out.println("Saturday");
        } else if (day == 3) {
            System.out.println("Sunday");
        } else if (day == 4) {
            System.out.println("Monday");
        } else if (day == 5) {
            System.out.println("Tuesday");
        } else if (day == 6) {
            System.out.println("Wednesday");
        }
        br.close();
    }
}