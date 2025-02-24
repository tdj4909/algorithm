import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (true){

            String s1 = br.readLine();
            String s2 = br.readLine();
            if (s1.equals("END") && s2.equals("END")){
                break;
            }
            idx++;

            if (s1.length() != s2.length()){
                sb.append("Case " + idx + ": different\n");
            } else {
                int[] alpha1 = new int[26];
                int[] alpha2 = new int[26];

                for (int i = 0; i < s1.length(); i++){
                    alpha1[s1.charAt(i) - 'a']++;
                    alpha2[s2.charAt(i) - 'a']++;
                }

                boolean flag = true;
                for (int i = 0; i < 26; i++){
                    if (alpha1[i] != alpha2[i]){
                        flag = false;
                        break;
                    }
                }

                if (flag){
                    sb.append("Case " + idx + ": same\n");
                } else {
                    sb.append("Case " + idx + ": different\n");
                }
            }

        }

        System.out.println(sb);
    }
}