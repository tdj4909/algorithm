import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            while (n-->0){
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String s = st.nextToken();
                if (map.containsKey(s)){
                    map.put(s, map.get(s) + 1);
                } else {
                    map.put(s, 1);
                }
            }

            int total = 0;
            if (map.size() > 1) {
                int sum = 1;
                for (int i : map.values()){
                    sum *= (i+1);
                }
                total += sum;
                total--;
            } else {
                for (int i : map.values()) {
                    total += i;
                }
            }

            System.out.println(total);
        }
    }
}