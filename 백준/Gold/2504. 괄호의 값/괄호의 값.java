import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<String> stack = new Stack<>();
        boolean flag = true;
        for (int i = 0; i < str.length(); i++){
            String in = String.valueOf(str.charAt(i));

            if (!stack.isEmpty() && in.equals(")")) {
                String tmp = stack.pop();
                if (tmp.equals("(")){
                    stack.push("2");
                } else if (tmp.equals("[")) {
                    flag = false;
                    break;
                } else {
                    if (!stack.isEmpty() && stack.peek().equals("(")) {
                        stack.pop();
                        stack.push(String.valueOf(Integer.parseInt(tmp) * 2));
                    } else {
                        stack.push(tmp);
                        stack.push(in);
                    }
                }
            } else if (!stack.isEmpty() && in.equals("]")) {
                String tmp = stack.pop();
                if (tmp.equals("[")){
                    stack.push("3");
                } else if (tmp.equals("(")) {
                    flag = false;
                    break;
                } else {
                    if (!stack.isEmpty() && stack.peek().equals("[")) {
                        stack.pop();
                        stack.push(String.valueOf(Integer.parseInt(tmp) * 3));
                    } else {
                        stack.push(tmp);
                        stack.push(in);
                    }
                }
            } else if (!in.equals("(")&&!in.equals("[")&&!in.equals(")")&&!in.equals("]")) {
                flag = false;
                break;
            } else{
                stack.push(in);
            }

            if (stack.size() >= 2) {
                String peek1 = stack.pop();
                String peek2 = stack.pop();
                if (!peek1.equals("(") && !peek1.equals("[") && !peek1.equals(")") && !peek1.equals("]")
                        && !peek2.equals("(") && !peek2.equals("[") && !peek2.equals(")") && !peek2.equals("]")) {
                    stack.push(String.valueOf(Integer.parseInt(peek1) + Integer.parseInt(peek2)));
                } else {
                    stack.push(peek2);
                    stack.push(peek1);
                }
            }

        }

        if (flag && stack.size() == 1 && !stack.peek().equals("(")&& !stack.peek().equals("[")&& !stack.peek().equals(")")&& !stack.peek().equals("]")){
            System.out.println(Integer.parseInt(stack.peek()));
        } else {
            System.out.println(0);
        }
    }
}