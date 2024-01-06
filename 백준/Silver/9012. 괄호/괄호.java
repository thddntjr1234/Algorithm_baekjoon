import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * 스택 자료구조를 사용하면 될 것으로 보이는데
         * 괄호 쌍에 대해 '('괄호는 push, ')'괄호는 pop을 수행하면 될 것 같다.
         */

         // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int cnt = 0; cnt<T; cnt++) {
            String input = br.readLine();
            char[] arr = input.toCharArray();

            // 2. 검증
            if (isVPS(arr)) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        // 3. 결과
        System.out.println(sb);
    }

    static boolean isVPS(char[] arr) {

        Stack<Character> st = new Stack<>();

        for (int i=0; i<arr.length; i++) {
            if (arr[i] == '(') {
                st.push(arr[i]);
            } else if (arr[i] == ')' && !st.isEmpty()) {
                st.pop();
            } else {
                return false;
            }
        }

        if (st.isEmpty()) {
            return true;
        } else { 
            return false;
        }
    }
}
