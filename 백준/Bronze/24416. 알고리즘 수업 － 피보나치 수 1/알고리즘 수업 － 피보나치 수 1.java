import java.util.*;
import java.io.*;

public class Main {
    static int N, count_recursion = 0, count_dp = 0;
    static int[] dp;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        fibonacci(N);
        fib(N);
        StringBuilder sb = new StringBuilder();
        sb.append(count_recursion).append(" ").append(count_dp);
        System.out.println(sb);
    }

    // dp를 사용한 피보나치
    static int fibonacci(int n) {
        dp[1] = 1;
        dp[2] = 1;

        for (int i=3; i<=n; i++) {
            count_dp += 1;
            dp[i] = dp[i-1] + dp[i-2]; // 코드 2
        }
        return dp[n];
    }

    // 재귀를 사용한 피보나치
    static int fib(int n) {
        if (n == 1 || n == 2) { // 코드 1
            count_recursion += 1; 
            return 1;
        }
        else return fib(n-1) + fib(n-2);
    }
}
