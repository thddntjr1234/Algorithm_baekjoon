import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int lastValue = 0;

        for (int i=0; i<N; i++) { // 15로 써버려서 틀렸음
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push" :
                    int num = Integer.parseInt(st.nextToken());
                    queue.add(num);
                    lastValue = num;
                    break;
                case "pop" :
                    if(queue.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(queue.poll()).append('\n');
                    break;
                case "size" :
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty" :
                    if(queue.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "front" :
                    if(queue.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(queue.peek()).append('\n');
                    break;
                case "back" :
                    if(queue.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(lastValue).append('\n');
            }
        }

        System.out.println(sb);
    }
}