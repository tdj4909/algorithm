import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++){
            if (map.containsKey(participant[i])){
                map.replace(participant[i], map.get(participant[i])+1);
            } else {
                map.put(participant[i], 1);
            }
        }
        for (int i = 0; i < completion.length; i++){
            if (map.get(completion[i]) == 1){
                map.remove(completion[i]);
            } else {
                map.replace(completion[i], map.get(completion[i])-1);
            }
        }
        String answer = map.keySet().toString().replace("[", "").replace("]", "");
        return answer;
    }
}