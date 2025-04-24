class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++){
            answer[i] = "";
        }

        boolean[][] board1 = new boolean[n][n];
        boolean[][] board2 = new boolean[n][n];

        for (int i = 0; i < n; i++){
            String s1 = Integer.toBinaryString(arr1[i]);
            String s2 = Integer.toBinaryString(arr2[i]);

            if (s1.length() != n){
                s1 = "0".repeat(n-s1.length()) + s1;
            }
            if (s2.length() != n){
                s2 = "0".repeat(n-s2.length()) + s2;
            }

            for (int j = 0; j < n; j++){
                if (s1.charAt(j) == '1'){
                    board1[i][j] = true;
                }

                if (s2.charAt(j) == '1'){
                    board2[i][j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (!board1[i][j] && !board2[i][j]){
                    answer[i] += " ";
                } else {
                    answer[i] += "#";
                }
            }
        }

        return answer;
    }
}