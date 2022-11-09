import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Integer[] dp;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new Integer[N+1];

        dp[1] = 0; // 최소값 설정
        System.out.println(recursion(N));
    }

    /*
     * 이전에 푼 dp 문제들과 비슷한 계열로 조건에 따라 최솟값을 비교하기 위한 식이 달라짐
     */
    static int recursion(int n) {
        if (dp[n] == null) {
            // n/3 -> O인 경우
            if(n%3 == 0) {
                if(n%2 == 0) {
                    dp[n] = Math.min(Math.min(recursion(n/3), recursion(n/2)), recursion(n-1))+1; // 모든 조건이 가능하면 전부 계산해서 최솟값 구하기
                }

                else dp[n] = Math.min(recursion(n/3), recursion(n-1))+1; // n/2가 불가능하면 n/3과 n-1만 계산하여 구하기
            }
            // n/3 -> X인 경우
            else {
                if (n%2 == 0) dp[n] = Math.min(recursion(n/2), recursion(n-1))+1; // n/2가 가능하면 n/2와 n-1 계산
                else dp[n] = recursion(n-1)+1; // 나눗셈 연산이 모두 불가능하면 n-1만 계산
            }
        }

        return dp[n];
    }
}