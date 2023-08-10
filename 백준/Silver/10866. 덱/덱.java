import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String instruction = st.nextToken();

            switch (instruction) {
                case "push_front":
                    int frontX = Integer.parseInt(st.nextToken());
                    deque.offerFirst(frontX);
                    break;

                case "push_back":
                    int backX = Integer.parseInt(st.nextToken());
                    deque.offerLast(backX);
                    break;

                case "pop_front":
                    if (deque.peekFirst() == null) sb.append(-1).append('\n');
                    else sb.append(deque.pollFirst()).append('\n');
                    break;

                case "pop_back":
                    if (deque.peekLast() == null) sb.append(-1).append('\n');
                    else sb.append(deque.pollLast()).append('\n');
                    break;

                case "size":
                    sb.append(deque.size()).append('\n');
                    break;

                case "empty":
                    if (deque.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;

                case "front":
                    if (deque.peekFirst() == null) sb.append(-1).append('\n');
                    else sb.append(deque.peekFirst()).append('\n');
                    break;
                    
                case "back":
                    if (deque.peekLast() == null) sb.append(-1).append('\n');
                    else sb.append(deque.peekLast()).append('\n');
                    break;
            }
        }

        System.out.println(sb.toString());
    }
}
