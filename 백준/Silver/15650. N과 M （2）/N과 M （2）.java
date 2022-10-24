import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static boolean[] visit;
    static int[] nums;

    /*
     * https://st-lab.tistory.com/115 를 참고해 작성한 더 나은 풀이
     */
    public static void dfs(int at, int depth) {
        if (depth == K) {
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        /* 
        * 더 나은 풀이 적용, at변수를 사용해 중복방문 확인을 하지 않아도 되니 이전 내용 삭제
        * at변수를 통해 재귀를 하게 되면, 재귀 이전에 사용한 값보다 큰 수를 대상으로만 깊어지며 탐색한다
        * 1, 2까지 사용했으면 세 번째 자리는 3, 4 중 하나가 오고 여기서 4는 다음에 호출하게 되는 재귀의
        * at값이 5가 되기 때문에 depth가 3인 채로 끝나게 되어 출력되지 않고, 3은 at가 4를 가져 depth가
        * 4까지 성공적으로 증가하므로 출력되게 되는 방식
        */
        for (int i=at; i<=N; i++) {
            nums[depth] = i;
            dfs(i+1, depth+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit = new boolean[N];
        nums = new int[K];

        dfs(1, 0);
    }
}