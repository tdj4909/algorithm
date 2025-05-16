import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String[] arr1 = new String[]{
                "Yakk",
                "Doh",
                "Seh",
                "Ghar",
                "Bang",
                "Sheesh"
        };
        String[] arr2 = new String[]{
                "Habb Yakk",
                "Dobara",
                "Dousa",
                "Dorgy",
                "Dabash",
                "Dosh"
        };

        for (int i = 1; i <= T; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            if ((a==4 && b==5) || (a==5 && b==4)){
                System.out.println("Case " + i + ": Sheesh Beesh");
            } else if(a==b){
                System.out.println("Case " + i + ": " + arr2[a]);
            } else {
                System.out.println("Case " + i + ": " + arr1[Math.max(a,b)] + " " + arr1[Math.min(a,b)]);
            }
        }
    }
}