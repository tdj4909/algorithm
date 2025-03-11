import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int priority : priorities) {
            queue.offer(priority);
        }

        while (location >= 0){
            int mx = Collections.max(queue);
            int n = queue.poll();
            if (n == mx){
                location--;
                answer++;
            } else {
                queue.offer(n);
                if (location == 0){
                    location = queue.size()-1;
                } else {
                    location--;
                }
            }
        }
        return answer;
    }
}