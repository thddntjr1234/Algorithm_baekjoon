import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];

        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int cnt = 0;
        // stack 추가하다가 seq만나면 pop, seq++ 을 무한반복, 아니면 +수행 -카운트 계산ㅁ해서 n아니면 NO?
        
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            sb.append('+').append('\n');

            while (!stack.isEmpty() && stack.peek() == seq[idx]) {
                stack.pop();
                idx++;
                cnt++;
                sb.append('-').append('\n');
            }
        }

        if (cnt == n) System.out.println(sb.toString());
        else System.out.println("NO");
    }
}
