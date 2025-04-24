class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;

        for (String s : dic){
            boolean[] used = new boolean[spell.length];
            for (int i = 0; i < spell.length; i++){
                if (s.contains(spell[i])){
                    used[i] = true;
                }
            }

            boolean chk = true;
            for (boolean b : used){
                if (!b){
                    chk = false;
                    break;
                }
            }

            if (chk){
                answer = 1;
                break;
            }
        }

        return answer;
    }
}