import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String oper = "";
        int idx = 1;
        while (!oper.equals("E")){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            oper = st.nextToken();
            int b = Integer.parseInt(st.nextToken());

            switch (oper){
                case ">":
                    if (a > b){
                        System.out.println("Case " + idx + ": true");
                    } else {
                        System.out.println("Case " + idx + ": false");
                    }
                    break;
                case ">=":
                    if (a >= b){
                        System.out.println("Case " + idx + ": true");
                    } else {
                        System.out.println("Case " + idx + ": false");
                    }
                    break;
                case "<":
                    if (a < b){
                        System.out.println("Case " + idx + ": true");
                    } else {
                        System.out.println("Case " + idx + ": false");
                    }
                    break;
                case "<=":
                    if (a <= b){
                        System.out.println("Case " + idx + ": true");
                    } else {
                        System.out.println("Case " + idx + ": false");
                    }
                    break;
                case "==":
                    if (a == b){
                        System.out.println("Case " + idx + ": true");
                    } else {
                        System.out.println("Case " + idx + ": false");
                    }
                    break;
                case "!=":
                    if (a != b){
                        System.out.println("Case " + idx + ": true");
                    } else {
                        System.out.println("Case " + idx + ": false");
                    }
                    break;
            }
            idx++;
        }

        br.close();
    }
}