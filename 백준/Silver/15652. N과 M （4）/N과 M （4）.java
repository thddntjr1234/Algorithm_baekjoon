import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();

    /*
     * 오름차순이고, 중복을 허용하므로 최솟값을 결정하는 at변수를 넣고, 중복을 체크하는 visit[] 배열은 사용하지 않는다.
     * 이외는 다른 N과 M문제와 동일함
     */
    public static void dfs(int at, int depth) {
        if (depth == K) {
            for (int num : nums) {
                sb.append(num).append(" ");
            }
            sb.append('\n');
            return;
        }
        // 오름차순이여야 하므로 dfs를 재귀호출할 때 시작하는 값은 i와 같아야 한다.
        // ex) 앞 자리가 3일 때, for는 i를 3부터 시작해 nums에 대입하고 다시 다음 depth로 재귀를 돌림
        for (int i=at; i<=N; i++) {
            nums[depth] = i;
            dfs(i, depth+1);
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nums = new int[K];

        dfs(1, 0);
        System.out.println(sb);
    }
}