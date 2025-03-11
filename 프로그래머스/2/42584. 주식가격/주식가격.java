import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++){
            while (!stack.isEmpty() && stack.peek()[0] > prices[i]){
                int[] p = stack.pop();
                answer[p[1]] = i - p[1];
            }
            stack.push(new int[]{prices[i], i});
        }
        while (!stack.isEmpty()){
            int[] p = stack.pop();
            answer[p[1]] = prices.length - 1 - p[1];
        }
        return answer;
    }
}