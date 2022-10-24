import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth) {
        if (depth == K) {
            for (int num : nums) {
                sb.append(num).append(" ");
            }
            sb.append('\n');
            return;
        }
        for (int i=1; i<=N; i++) {
            nums[depth] = i;
            dfs(depth+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new int[K];
        dfs(0);
        System.out.println(sb);
    }
}