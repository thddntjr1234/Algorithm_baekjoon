import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int length = s.length();
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<length; i++) {
            if(s.charAt(i) == '(') {
                stack.push(1);
            }
            else {
                if(stack.isEmpty()) {
                    return false;
                }
                else {
                    stack.pop();
                }
            }
        }
        answer = (stack.isEmpty()) ? true : false;
        return answer;
    }
}