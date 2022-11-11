import java.io.*;
import java.util.*;

public class Main {
    static int N, max = 0;
    static Integer[] dp;
    static int[] arr;
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new Integer[N+1];
        arr = new int[N+1];

        for (int i=1; i<=N; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = arr[0];
        dp[1] = arr[1];
        if(N >= 2) dp[2] = arr[2]+arr[1];
        System.out.println(recursion(N));
    }
    /*
     * https://st-lab.tistory.com/135를 참고한 풀이
     * 재귀 특성이 2579 계단 오르기와 비슷한데 주요한 차이점은 마지막 잔에서 최대값을 찾는 것이 아니란 것임
     * 계단 오르기에서의 마지막 계단 N에 대해선 recursion(n-2), recursion(n-1)+arr[n-1]에 대해 서로 최대값을 비교해서 dp[N]에 저장하는 것이였으나
     * 여기서는 마지막이 아닌 위치에서 최대값을 가질 수 있기 때문에 해당 위치에서 3번 연속하지 않고 최대값을 찾을 수 있도록
     * 위의 수식에서의 최대값과 n-1에서의 최대값을 비교한다.
     * 재귀 특성상 dp[n-1] dp[n-2] ...dp[1]까지 내려오면서 값을 저장하는데, main에서 재귀를 시작하기 전에 N이 2가 넘는 경우 recursion에서
     * 배열 인덱스 참조 오류가 일어날 수 있으니 dp[0~2]까지 값을 따로 저장해 준다.
     */
    static int recursion(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(Math.max(recursion(n-2), recursion(n-3) + arr[n-1])+arr[n], recursion(n-1));
        }

        return dp[n];
    }
}