import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hashMap = new HashMap<>();
        while (N-- > 0){
            String s = br.readLine();
            if (hashMap.containsKey(s)){
                hashMap.replace(s, hashMap.get(s) + 1);
            } else {
                hashMap.put(s, 1);
            }
        }

        int max = 0;
        for (int i : hashMap.values()){
            max = Math.max(max, i);
        }

        List<String> list = new ArrayList<>(hashMap.keySet());
        Collections.sort(list);
        for (String s : list){
            if (hashMap.get(s) == max){
                System.out.println(s);
                break;
            }
        }
    }
}