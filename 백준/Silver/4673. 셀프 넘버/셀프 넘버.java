public class Main {
    public static void main(String[] args) {
        boolean[] num = new boolean[10001];
        int s = 1;

        while (s <= 10000){
            int n = s;
            String str = String.valueOf(s);
            for (int i = 0; i < str.length(); i++){
                n += Integer.parseInt(String.valueOf(str.charAt(i)));
            }

            if (n <= 10000) {
                num[n] = true;
            }
            s++;
        }

        for (int i = 1; i <= 10000; i++){
            if (!num[i]){
                System.out.println(i);
            }
        }
    }
}