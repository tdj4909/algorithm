import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Num implements Comparable<Num> {
    int n;
    String s;

    public Num(int n, String s){
        this.n = n;
        this.s = s;
    }

    @Override
    public int compareTo(Num o){
        return this.s.compareTo(o.s);
    }

}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        List<Num> list = new ArrayList<>();
        String[] sList = new String[]{
                "zero",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine",
        };

        for (int i = M; i <= N; i++){
            String result = "";
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++){
                result += sList[Integer.parseInt(String.valueOf(s.charAt(j)))];
            }
            list.add(new Num(i, result));
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N-M+1; i++){
            if (i!=0 && i%10==0){
                sb.append("\n");
            }
            sb.append(list.get(i).n).append(" ");
        }

        System.out.println(sb);
    }
}