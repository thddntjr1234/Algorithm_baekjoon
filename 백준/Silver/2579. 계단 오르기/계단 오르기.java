import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dp, arr;
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N+1];
        dp = new int[N+1];

        for (int i=1; i<=N; i++) {
            arr[i] = sc.nextInt();
        }

        dp[1] = arr[1];

        if(N >= 2) dp[2] = arr[1]+arr[2];
        
        for (int i=3; i<=N; i++) {
            dp[i] = Math.max(dp[i-3]+arr[i-1], dp[i-2]) + arr[i];
        }

        System.out.println(dp[N]);
    }
}