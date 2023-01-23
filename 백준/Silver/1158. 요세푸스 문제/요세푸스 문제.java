import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> result = new ArrayList<>();

        // 큐 초기 설정
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {              // 큐에 숫자가 존재하지 않을 때 까지 실행
            for (int i=0; i<K; i++) {           // 0~K-1의 범위로 실행
                if (i == K-1) {                   // K-1까지 도달하면 순열에 해당 큐의 값을 추가
                    result.add(queue.poll());
                }

                else {                          // 이외의 경우에는 다시 큐에 삽입
                    queue.offer(queue.poll());
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i=0; i<result.size(); i++) {
            if (i == result.size()-1) {
                sb.append(result.get(i));
                break;
            }

            sb.append(result.get(i)).append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}