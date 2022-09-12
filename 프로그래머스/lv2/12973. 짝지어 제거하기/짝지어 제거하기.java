import java.util.*;

class Solution
{
    public int solution(String s)
    {
        // 바로 전에 입력한 문자와 현재 문자를 비교하므로 스택을 사용하면 간편
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            // 스택이 비어있지 않고, s[i]와 s[i-1]의 문자가 같다면 문자 삭제  
            if(!stack.isEmpty() && ch == stack.peek()) {
                stack.pop();
            }
            // 아니면 문자 추가
            else stack.push(ch);
        }

        return (stack.size() == 0) ? 1 : 0;
    }
}