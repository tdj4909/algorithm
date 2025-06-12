import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        while (N-->0){
            String s = br.readLine();
            map.put(s, map.getOrDefault(s,0)+1);
        }
        
        long result = 0;
        int max = 0;
        for (String s : map.keySet()){
            if (map.get(s) > max){
                max = map.get(s);
                result = Long.parseLong(s);
            } else if (map.get(s) == max) {
                result = Math.min(result, Long.parseLong(s));
            }
        }

        System.out.println(result);
    }
}