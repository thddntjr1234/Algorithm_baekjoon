import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String instruction = st.nextToken();

            switch(instruction) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    queue.add(num);
                    break;

                case "pop":
                    if (!queue.isEmpty()) System.out.println(queue.poll());
                    else System.out.println(-1);
                    break;

                case "size":
                    System.out.println(queue.size());
                    break;

                case "empty":
                    if (queue.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;

                case "front":
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(queue.peek());
                    break;

                case "back":
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }

                    int size = queue.size();
                    for (int j = 0; j < size; j++) {
                        if (j == size-1) System.out.println(queue.peek());
                        int tmp = queue.poll();
                        queue.add(tmp);
                    }
                    break;
            }
        }
    }
}
