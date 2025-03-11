import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Queue<String> queue = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++){
            if (!queue.isEmpty() && queue.peek().equals("(") && s.charAt(i) == ')'){
                queue.poll();
            } else {
                queue.offer(String.valueOf(s.charAt(i)));
            }
        }
        if (!queue.isEmpty()){
            answer = false;
        }
        return answer;
    }
}