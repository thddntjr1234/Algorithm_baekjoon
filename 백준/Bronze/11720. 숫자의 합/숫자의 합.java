import java.util.Scanner;

public class Main { 
    public static void main(String[] args) {
        int N, sum = 0;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        String nums = sc.next();

        for (int i = 0; i < nums.length(); i++) {
            sum += nums.charAt(i)-'0';
        }

        System.out.println(sum);
    }
}