import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){
            String str = br.readLine();
            LinkedList<String> result = new LinkedList<String>();
            ListIterator<String> iterator = result.listIterator();

            for (int j = 0; j < str.length(); j++){
                char ch = str.charAt(j);

                if (ch == '<'){
                    if (iterator.hasPrevious()){
                        iterator.previous();
                    }
                } else if (ch == '>') {
                    if (iterator.hasNext()){
                        iterator.next();
                    }
                } else if (ch == '-') {
                    if (iterator.hasPrevious()){
                        iterator.previous();
                        iterator.remove();
                    }
                } else {
                    iterator.add(String.valueOf(ch));
                }
            }

            for (String s : result){
                sb.append(s);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
        br.close();
    }
}