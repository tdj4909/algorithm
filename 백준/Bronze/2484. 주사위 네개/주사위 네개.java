import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            HashMap<Integer, Integer> dice = new HashMap<>();

            for (int j = 0; j < 4; j++){
                int n = Integer.parseInt(st.nextToken());
                if (dice.containsKey(n)){
                    dice.replace(n, dice.get(n) + 1);
                } else {
                    dice.put(n, 1);
                }
            }

            int cnt = 0;
            for (int key : dice.keySet()){
                if (dice.get(key) == 2){
                    cnt++;
                }
            }

            int tmp = 2000;
            if (cnt == 2){
                for (int key : dice.keySet()){
                    if (dice.get(key) == 2){
                        tmp += 500 * key;
                    }
                }
                result = Math.max(result, tmp);
            } else if (dice.containsValue(4) || dice.containsValue(3) || dice.containsValue(2)){
                for (int key : dice.keySet()){
                    if (dice.get(key) == 4){
                        result = Math.max(result, 50000 + key * 5000);
                    } else if (dice.get(key) == 3) {
                        result = Math.max(result, 10000 + key * 1000);
                    } else if (dice.get(key) == 2) {
                        result = Math.max(result, 1000 + key * 100);
                    }
                }
            } else {
                result = Math.max(result, Collections.max(dice.keySet()) * 100);
            }
        }
        System.out.println(result);
    }
}