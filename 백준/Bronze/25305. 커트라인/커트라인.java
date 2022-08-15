import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

// 25305
public class Main {
    public static void main(String[] args) {
        int N, k;
        ArrayList numList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < N; i++){
            int num = sc.nextInt();
            numList.add(num);
        }
        numList.sort(Comparator.reverseOrder());

        System.out.println(numList.get(k-1));
    }
}