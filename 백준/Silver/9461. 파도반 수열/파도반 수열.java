import java.io.*;
import java.util.*;

public class Main {
    static long[] dp; // 100은 integer 오버플로우 발생하게 되니 long타입 선언
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        int T = Integer.parseInt(br.readLine());
        dp = new long[101]; // 한번 구한 값은 계속 쓰므로 초기화 X

        for (int i=0; i<T; i++) {
            N = Integer.parseInt(br.readLine());
            System.out.println(tri(N));
        }
    }

    static long tri(int n) {
        if (n <= 3) return 1L;

        else if (dp[n] > 0) return dp[n];
        
        else return dp[n] = tri(n-2) + tri(n-3);
    }
}