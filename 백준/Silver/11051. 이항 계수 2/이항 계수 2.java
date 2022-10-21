import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[N+1][K+1];
        System.out.println(BC(N, K));
    }

    /*
     * 이항계수를 구하는 함수 BC
     * DP를 사용하였으므로 이미 구한 값에 대해 다시 계산하지 않아 재귀횟수가 줄어듬
    */
    static int BC(int N, int K) {
        if(dp[N][K] > 0) { // 이미 구한 값이라면 또 계산하지 않고 구한 값을 리턴
            return dp[N][K];
        }
        /*
         * N==K인 경우 N! / (N-K)!*K! 인데 결국 N! / N!이 되므로 결과는 1이고
         * K==0인 경우도 N! / N!이 되어 결과가 1이므로 둘의 경우에는 DP 배열에 1을 넣어준다.
        */
        if(N==K || K == 0) { 
            return dp[N][K] = 1;
        }

        /*
         * 이항계수는 nCk로 표현할 수 있고, n+1Ck+1 = nCk + nCk+1이며
         * 따라서 nCk = n-1Ck-1 + n-1Ck 이므로 다음과 같은 재귀를 통해 nCk를 구할 수 있다.
         * 여기서 재귀 할 때마다 10007로 나누어 나머지를 대입하는 이유는
         * 팩토리얼 시 정수형 변수의 크기를 초과한 값을 가지기 때문으로 결과값에서 나머지를 한 번 구하는 것과 재귀 시마다 나머지를 구해서 넣는 것은
         * 같은 성질을 가지기 떄문에(모듈러 연산의 성질 : https://st-lab.tistory.com/19) 재귀 시마다 나머지 값을 구하는 것임.
         */
        return dp[N][K] = (BC(N-1, K-1) + BC(N-1, K)) % 10007;
    }
}