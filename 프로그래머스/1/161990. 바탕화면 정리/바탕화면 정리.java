class Solution {
    public int[] solution(String[] wallpaper) {

        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE;
        int rdy = Integer.MIN_VALUE;

        for (int i = 0; i < wallpaper.length; i++){
            String s = wallpaper[i];
            for (int j = 0; j < s.length(); j++){
                if (s.charAt(j) == '#'){
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i+1);
                    rdy = Math.max(rdy, j+1);
                }
            }
        }

        int[] answer = new int[]{lux, luy, rdx, rdy};
        return answer;
    }
}