import java.io.*;
import java.util.*;

public class Main {
    static int N, max;
    static int[] arr;
    static Integer[] dp;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N]; // 입력값을 담는 배열
        dp = new Integer[N]; // 각 인덱스에서의 최대 연속합을 담는 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        max = arr[0];
        recursion(N-1);
        System.out.println(max); // dp엔 인덱스별로 최고 연속합들이 담겨있으므로 최대값 추출
    }

    /*
     * 재귀 특성을 찾는 것이 제일 어려운 것 같음. 연속합은 중간에 -값이 있더라도 상관없이 최대 합을 뽑는 문제
     * dp의 각 인덱스는 하향식으로 최대 연속합을 찾아 저장함
     * ex n == 3이면 n이 1이 될 때까지 재귀해 내려간 뒤
     * dp[1] = dp[0]+arr[1] ? arr[1] 비교한 값이, dp[2] = dp[1]+arr[2] ? arr[1] 비교한 값 이런 방식으로 값을 구해오면서
     * 각 재귀마다 return해 올라온다. 이렇게 올라오면 결국 dp[2]가 구해지므로 recursion(n-1)은 dp[2]를 리턴하게 되고
     * dp[2]+arr[3]과 arr[3]을 비교한 값 중에 최대값을 리턴하는 순서가 된다
     */
    static int recursion(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(recursion(n-1) + arr[n], arr[n]);
            max = Math.max(max, dp[n]);
        }

        return dp[n];
    }
}