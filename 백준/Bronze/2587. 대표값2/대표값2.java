import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int sum = 0;
        int[] arr = new int[5];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);

        System.out.println(sum/5);
        System.out.println(arr[2]);
    }
}