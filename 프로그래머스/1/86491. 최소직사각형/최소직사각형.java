class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        for (int i = 0; i < sizes.length; i++){
            if (sizes[i][0] < sizes[i][1]){
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }

        int wMax = Integer.MIN_VALUE;
        int hMax = Integer.MIN_VALUE;
        for (int i = 0 ; i < sizes.length; i++){
            wMax = Math.max(wMax, sizes[i][0]);
            hMax = Math.max(hMax, sizes[i][1]);
        }
        answer = wMax * hMax;
        
        return answer;
    }
}