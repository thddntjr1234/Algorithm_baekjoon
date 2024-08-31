import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        int sum = 0;
        int temp = 1;
        /**
         * 접근법
         * 스택 자료구조 사용
         * 반복분 안에서 모든 괄호에 대해 일일히 조건을 검사하면서 계산하지 않고 내부 괄호가 없는 괄호에 대해서만 검사하여 더해야 한다.
         * ex) ([](([])))인 경우 첫 번째 []와 두 번째 []만 구하여 서로 더하면 되는 것
         * 즉 괄호 간의 덧셈은 단순 sum에 더하는 것으로 해결되므로 안쪽 괄호의 값을 구하면 된다.
         * 
         * 구현방법
         * 여는 괄호의 경우 곱셈 결과를 임시로 가지는 temp 변수에 괄호의 값을 계속해서 곱하고,
         * 닫는 괄호가 나오는 경우 바로 이전 괄호가 여는 괄호일 때만 그 값을 sum에 더한다.
         * 이전 괄호가 닫는 괄호일 경우, temp의 값을 해당 괄호의 값으로 나눈다.
         * 
         * -> 왜 나눠야 하는가? ([]([]))의 경우 () 괄호 내에 있는 [], ([]) 괄호는 ([]), (([]))값으로 계산되어야 한다.
         * 그러나 첫 번째 괄호 []에서 해당 값을 sum에 더하고 난 뒤 temp / 3 하지 않으면 temp는 6을 가지고 있게 된다.
         * 그러면 다음 괄호 (([]))를 구해야 하는데 ([([])]) 값이 구해지게 된다.
         * 따라서, temp의 값은 괄호가 닫힐 때 해당 괄호의 값을 곱하기 전으로 돌아가야 하므로 닫힐 괄호의 값으로 나눠야 한다.
         */
        for (int i = 0; i < input.length; i++) {
            char c = input[i];

            if (c == '(') {
                stack.push(c);
                temp *= 2;
            } else if (c == '[') {
                stack.push(c);
                temp *= 3;
            } else if (c == ')') {
                // stack.isEmpty || stack.peek = [이면 return
                if (stack.isEmpty() || stack.peek() == '[') {
                    sum = 0;
                    break;
                }

                // 이전 괄호가 여는 괄호였다면 sum += temp 하고 temp / 2
                if (input[i-1] == '(') {
                    sum += temp;
                }
                stack.pop();
                temp /= 2;
            } else {
                // stack.isEmpty || stack.peek = (이면 return
                if (stack.isEmpty() || stack.peek() == '(') {
                    sum = 0;
                    break;
                }
                
                // 이전 괄호가 여는 괄호였다면 sum += temp 하고 temp / 3
                if (input[i-1] == '[') {
                    sum += temp;
                }
                stack.pop();
                temp /= 3;
            }
        }

        if (!stack.empty()) {
            sum = 0;
        }

        System.out.println(sum);
    }
}