import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;
    static int[][] arr;
    static int N, min;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][3];
        dp = new int[N][3];

        for (int i=0; i<N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }
        
        // 이렇게 선언해 줘야 인덱스가 -1로 넘어가지 않고 정상적으로 재귀가 실행됨
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        int result = Math.min(paintHouse(N-1, 0), paintHouse(N-1, 1));
        result = Math.min(result , paintHouse(N-1, 2));
        System.out.println(result);
    }

    static int paintHouse(int n, int color) {
        if(dp[n][color] == 0) {
            if (color == 0) { // N번 집이 Red일 때
                dp[n][0] = Math.min(paintHouse(n-1, 1), paintHouse(n-1, 2)) + arr[n][0];
            }
            else if (color == 1) { // N번 집이 Green일 때
                dp[n][1] = Math.min(paintHouse(n-1, 0), paintHouse(n-1, 2)) + arr[n][1];
            }

            else if (color == 2) { // N번 집이 Blue일 때
                dp[n][2] = Math.min(paintHouse(n-1, 0), paintHouse(n-1, 1)) + arr[n][2];
            }
        }
        
        return dp[n][color];
    }
}