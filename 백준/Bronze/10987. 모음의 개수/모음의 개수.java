import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = 0;
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'a' ||
                    s.charAt(i) == 'e' ||
                    s.charAt(i) == 'i' ||
                    s.charAt(i) == 'o' ||
                    s.charAt(i) == 'u'){
                count++;
            }
        }
        bw.write(count+"");
        bw.close();
        br.close();
    }
}