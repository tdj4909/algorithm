import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        boolean[] chk = new boolean[progresses.length];
        for (int i = 0; i < 100; i++){

            for (int j = 0; j < progresses.length; j++){
                progresses[j] += speeds[j];
            }
            int cnt = 0;
            for (int j = 0; j < progresses.length; j++){
                if (progresses[j] < 100 && !chk[j]){
                    break;
                }
                if (progresses[j] >= 100 && !chk[j]){
                    chk[j] = true;
                    cnt++;
                }
            }
            if (cnt != 0){
                list.add(cnt);
            }
        }

        int[] answer = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return answer;
    }
}