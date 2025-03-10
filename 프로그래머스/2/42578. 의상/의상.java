import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes){
            if (map.containsKey(cloth[1])){
                map.replace(cloth[1], map.get(cloth[1])+ 1);
            } else {
                map.put(cloth[1], 1);
            }
        }
        if (map.size() == 1){
            answer = map.get(clothes[0][1]);
        } else {
            answer = 1;
            for (String str : map.keySet()){
                answer *= map.get(str) + 1;
            }
            answer--;
        }
        return answer;
    }
}