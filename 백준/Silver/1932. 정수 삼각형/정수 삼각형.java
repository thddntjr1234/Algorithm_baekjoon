import java.io.*;
import java.util.*;

import javax.swing.SpinnerDateModel;

public class Main {
    static int N, max;
    static int[][] arr;
    static Integer[][] dp;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new Integer[N][N];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<=i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<N; i++) { // dp배열의 맨 끝에서는 더이상 계산할 수 있는 수가 없으므로 arr배열의 값을 대입해줌
            dp[N-1][i] = arr[N-1][i];
        }

        System.out.println(recursion(0, 0)); // 배열의 범위가 0~N-1이니 0부터(상단부터) 시작
    }

    /*
     * 전 문제인 rgb거리와 연속합 문제와 비슷하다. 재귀 특성은 결국 N줄부터 시작해 1줄까지 올라오면서 모든 총합을 구하고 그 중 가장 큰 값을 선택해오는 것임
     * 선택할 수 있는 수는 대각선 왼쪽, 오른쪽이지만 실제 입력값 기준으로 보면 직각삼각형 모양으로 즉 index, index+1값을 기준으로 비교하는 셈이 된다.
     * 때문에 n 재귀에서는 n+1줄의 index, index+1 값에 대해서 재귀를 수행하고 맨 밑의 줄에 도달할 때 까지 같은 과정을 반복한다.
     */
    static int recursion(int n, int index) {
        if (dp[n][index] == null) { // 입력값 중 0도 포함하기 때문에 0을 비교하면 오류가 나게 된다. Integer배열로 선언하면 null로 초기화되므로 이를 이용
            dp[n][index] = Math.max(recursion(n+1, index), recursion(n+1, index+1)) + arr[n][index];
        }

        return dp[n][index];
    }
}