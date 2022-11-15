import java.io.*;
import java.util.*;

public class Main {
    static int[] arr, dp;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp =  new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i=0; i<N; i++) {
            max = Math.max(max, recursion(i));
        }

        System.out.println(max);
    }

    /*
     * 여기서 이전 dp문제들은 보통 dp배열에 총합을 저장했는데 여기서는 길이를 저장한다(비슷한 개념이지만 조금 다르다)
     * 각 dp[n]에서는 n-1 ~ 0에 대해서 자신보다 작은 수를 찾아가면서 부분수열을 찾는데, 이렇게 전체 범위에 대해서 탐색하지 않으면
     * 먼 거리에서 만들어지는 최대 부분수열을 찾을 수 없게 되기 때문에 전체 범위를 대상으로 탐색하는 것(시간복잡도는 n^2가 된다. main에서 N만큼 재귀를 호출하고 재귀 안에서 for로 n-1~0까지 돌리기 때문에)
     * 때문에 모든 dp는 최소 1의 값을 가지고, 탐색 여부를 확인하기 위해 dp값이 0일 때 1로 그때그떄 초기화해주는 방식으로 한다.
     */
    static int recursion(int n) {
        if(dp[n] == 0) {
            dp[n] = 1;

            for(int i=n-1; i>=0; i--) {
                if(arr[i] < arr[n]) {
                    // 현재 dp값과 찾은 N보다 작은 값의 인덱스 i에 대해 재귀로 더 작은 수를 탐색
                    // +1은 arr[N]이 arr[i]보다 크기 때문에 부분수열을 이루므로 길이를 가산한 것
                    dp[n] = Math.max(recursion(i)+1, dp[n]); 
                }
            }
        }

        return dp[n];
    }
}