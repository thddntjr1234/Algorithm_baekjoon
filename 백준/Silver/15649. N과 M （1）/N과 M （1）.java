import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static boolean[] visit;
    static int[] nums;

    /*
     * 15649 문제는 백트래킹 중 깊이 우선 탐색을 사용함
     * visit 배열의 인덱스 번호는 사용하는 숫자에 해당하기 때문에 해당 배열의 인덱스가 true값이면
     * 그 수는 이미 사용한 수임을 의미한다. 또 depth가 수열의 길이를 만족시킬 때(M) 까지 증가하는데
     * 이 때 한 수를 사용했으면 nums[depth] 에 수를 등록하고, 다음 depth로 넘어간다.
     * 해당 depth에 대해 백트래킹하며 모든 수열을 찾아낸다면 다음 경우의 수를 위해 해당 숫자에 대해서 다시
     * visit배열에 false를 입력해 준다.
     */
    public static void dfs(int depth) {
        if (depth == M) {
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
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N];
        nums = new int[M];
        dfs(0);
    }
} 