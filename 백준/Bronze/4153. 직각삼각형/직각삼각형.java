import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
    static int x, y, z;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            x = sc.nextInt();
            y = sc.nextInt();
            z = sc.nextInt();

            if (x == 0 && y == 0 && z == 0) {
                break;
            }

            if (x*x + y*y == z*z) {
                System.out.println("right");
            }

            else if (x*x + z*z == y*y) {
                System.out.println("right");
            }

            else if (y*y + z*z == x*x) {
                System.out.println("right");
            }

            else {
                System.out.println("wrong");
            }
        }
    }
}