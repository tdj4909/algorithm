import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> preList;
    static ArrayList<Integer> postList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        preList = new ArrayList<>();
        postList = new ArrayList<>();

        String str;
        while ((str = br.readLine()) != null){
            preList.add(Integer.parseInt(str));
        }

        search(0, preList.size());

        for (int i = postList.size() - 1; i >= 0; i--){
            System.out.println(postList.get(i));
        }
    }

    public static void search(int start, int end){
        if (start == end){
            return;
        }
        postList.add(preList.get(start));

        int idx = start + 1;
        for (int i = idx; i < end; i++){
            if (preList.get(i) > preList.get(start)){
                idx = i;
                break;
            }
        }

        search(idx, end);
        search(start + 1, idx);
    }
}