import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (P-->0){
            String s = br.readLine();
            int[] tc = new int[8];

            for (int i = 1; i <= 38; i++){
                if (s.charAt(i-1) == 'H'){
                    if (s.charAt(i) == 'H'){
                        if (s.charAt(i+1) == 'H'){
                            tc[7]++;
                        } else {
                            tc[6]++;
                        }
                    } else {
                        if (s.charAt(i+1) == 'H'){
                            tc[5]++;
                        } else {
                            tc[4]++;
                        }
                    }
                } else {
                    if (s.charAt(i) == 'H'){
                        if (s.charAt(i+1) == 'H'){
                            tc[3]++;
                        } else {
                            tc[2]++;
                        }
                    } else if (s.charAt(i) == 'T') {
                        if (s.charAt(i+1) == 'H'){
                            tc[1]++;
                        } else {
                            tc[0]++;
                        }
                    }
                }
            }


            for (int j : tc){
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}