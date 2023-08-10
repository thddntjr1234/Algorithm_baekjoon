import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=1; i<=n; i++) {
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int cnt = 0;

        for (int i=0; i<m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int leftCount = 0, rightCount = 0;

            Deque<Integer> leftCaseDeque = new ArrayDeque<>();
            Deque<Integer> rightCaseDeque = new ArrayDeque<>();

            // 케이스별로 사용할 dequqe에 깊은 복사를 수행
            for (int num : deque) {
                leftCaseDeque.add(num);
                rightCaseDeque.add(num);
            }

            // 왼쪽으로만 이동하는 케이스
            while(true) {
                if (leftCaseDeque.peekFirst() == target) {
                    leftCaseDeque.pollFirst();
                    break;
                }
                leftCaseDeque.offerLast(leftCaseDeque.pollFirst());
                leftCount++;
            }

            // 오른쪽으로만 이동하는 케이스
            while(true) {
                if (rightCaseDeque.peekFirst() == target) {
                    rightCaseDeque.pollFirst();
                    break;
                }
                rightCaseDeque.offerFirst(rightCaseDeque.pollLast());
                rightCount++;
            }

            // 최소값으로 수행한 케이스의 deque 값을 원 deque에게 얕은 복사로 주입해줌
            if (leftCount < rightCount) deque = leftCaseDeque;
            else deque = rightCaseDeque;

            cnt += Math.min(leftCount, rightCount);
        }

        System.out.println(cnt);
    }
}
