import java.util.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    static boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        String s = "";
        visited = new boolean[numbers.length()];
        bt(numbers, s);
        for (int n : set){
            boolean chk = true;

            if (n >= 2){
                for (int i = 2; i < Math.ceil(Math.sqrt(n+1)); i++){
                    if (n%i == 0){
                        chk = false;
                    }
                }
            } else {
                chk = false;
            }

            if (chk){
                answer++;
            }
        }
        
        return answer;
    }

    static void bt(String numbers, String s){
        for (int i = 0; i < numbers.length(); i++){
            if (!visited[i]){
                visited[i] = true;
                s += numbers.charAt(i);
                set.add(Integer.parseInt(s));
                bt(numbers, s);
                visited[i] = false;
                s = s.substring(0,s.length()-1);
            }
        }
    }
}