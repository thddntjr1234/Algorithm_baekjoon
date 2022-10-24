import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static boolean[] visit;
    static int[] nums;

    /*
     * 15649 N과 M(1)문제와 동일하나 오름차순 조건에 따라 일부가 약간 변경됨
     * depth == K일 때 nums에 들어간 수열이 오름차순인지를 먼저 검증하고 오름차순이 아닌 경우엔 return해 해당 수열의 출력을 패스함
     * 이 방식 외에도 dfs에서 다음 dfs를 호출하기 전 nums[depth-1]과 비교해 보고 클 시엔 dfs를 호출하지 않고 return하는 방식으로 백트래킹을 더 구현할 수 있을 것 같다.
     */
    public static void dfs(int depth) {
        if (depth == K) {
            int prep = nums[0];
            for (int i=0; i<K; i++) {
                if(prep > nums[i]) return;
                else prep = nums[i];
            }

            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        
        for (int i=0; i<N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                nums[depth] = i+1;
                dfs(depth+1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit = new boolean[N];
        nums = new int[K];
        dfs(0);
    }
}