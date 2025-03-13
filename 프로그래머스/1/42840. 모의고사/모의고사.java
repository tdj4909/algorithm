import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] aList = new int[]{1,2,3,4,5};
        int[] bList = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] cList = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int a = 0;
        int b = 0;
        int c = 0;

        for (int i = 0; i < answers.length; i++){
            if (answers[i] == aList[i%5]){
                a++;
            }

            if (answers[i] == bList[i%8]) {
                b++;
            }

            if (answers[i] == cList[i%10]) {
                c++;
            }
        }


        int max = Math.max(a,Math.max(b,c));
        ArrayList<Integer> list = new ArrayList<>();
        if (a == max){
            list.add(1);
        }
        if (b == max){
            list.add(2);
        }
        if (c == max){
            list.add(3);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}