import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = 1000 - sc.nextInt();
        int result = 0;

        if (money>=500){
            result += money / 500;
            money = money % 500;
        }
        if (money>=100){
            result += money / 100;
            money = money % 100;
        }
        if (money>=50){
            result += money / 50;
            money = money % 50;
        }
        if (money>=10){
            result += money / 10;
            money = money % 10;
        }
        if (money>=5){
            result += money / 5;
            money = money % 5;
        }

        result += money;

        System.out.print(result);
    }
}