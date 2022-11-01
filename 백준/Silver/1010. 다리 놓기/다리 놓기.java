import java.util.*;
import java.io.*;

public class Main {
    static int T, N, K;
    static int[][] dp;

    /*
     * 이 문제는 11051 이항계수 문제와 같은 계열이다.
     * n개 중에서 k개를 뽑는 문제는 조합 공식을 사용하고, 조합 공식은 중복을 허용하지 않기 떄문에
     * 1, 2 순으로 뽑나 2, 1순으로 뽑나 동일한 조합으로 판정한다. 즉 2, 1의 순서로 뽑는 경우는 고려하지 않고
     * 조합 공식을 적용할 수 있음을 말한다. 반대로 순서만 달라도 경우의 수로 인정하려면 15649~15652 N과 M문제와 같이
     * 백트래킹을 사용해서 완탐을 구현할 수 있다.
     * 풀이는 11051과 거의 동일함.
     */
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 동쪽의 다리 M개중에서 서쪽의 다리 N개를 고르는 문제이니 거꾸로 대입해준다
            K = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            dp = new int[N+1][K+1]; 
            System.out.println(BC(N, K));
        }
    }

    static int BC(int n, int k) {
        if (dp[n][k] > 0) return dp[n][k]; // dp[n][k]가 이미 구해진 경우는 그 수를 그대로 사용

        // n==k인 경우는 n개에서 n개를 뽑으므로 1이고, k==0인 경우는
        // n! / 0!*n!이므로 n! / n! == 1이다. 때문에 둘이 같이 묶어준다
        else if (n == k || k == 0) { 
            return dp[n][k] = 1;
        }

        // 이외의 경우에는 재귀를 통해 수를 구해야 하므로 
        // 조합의 공식인 nCk = n-1Ck-1 + n-1Ck를 이용해 Top-Down으로 풀이한다
        else {
            return dp[n][k] = BC(n-1, k-1) + BC(n-1, k);
        }
    }
}