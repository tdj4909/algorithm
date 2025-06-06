import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Student implements Comparable<Student> {
    int country;
    int num;
    int score;

    Student(int country, int num, int score){
        this.country = country;
        this.num = num;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return o.score-this.score;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();
        StringTokenizer st;

        while (N-->0){
            st = new StringTokenizer(br.readLine());
            list.add(new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);

        List<Student> result = new ArrayList<>();
        for (Student s : list){
            if (result.size() == 2){
                if (result.get(0).country == result.get(1).country
                        && result.get(1).country == s.country){
                    continue;
                } else {
                    result.add(s);
                    break;
                }
            } else {
                result.add(s);
            }
        }

        for (Student s : result){
            System.out.println(s.country + " " + s.num);
        }
    }
}