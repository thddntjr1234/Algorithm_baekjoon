import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        int tmp;
        
        for (int i = arr.length-1; i >= 0; i--) {
            tmp = arr[i];
            // 스택이 비어있으면 peek 없이 바로 입력
            if (stack.empty()) {
                stack.push(arr[i]);
            }
            
            // 비어있지 않으면 peek()과 tmp값을 비교해서 연속 숫자인지 확인
            else if (stack.peek() != tmp) {
                stack.push(arr[i]);
            }
        }

        int[] answer = new int[stack.size()];
        int size = stack.size();
        
        for (int i=0; i<size; i++) {
            answer[i] = stack.pop();
        }
        
        return answer;
    }
}