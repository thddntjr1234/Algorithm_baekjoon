import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int x=0; x<s.length(); x++) {
            Boolean iscorrect = true;
            Stack<Character> stack = new Stack<Character>();
            
            StringBuilder sb = new StringBuilder(s);
            String move = sb.substring(0, x);
            sb.delete(0, x);
            sb.append(move); 
            
            /* 
            이전 올바른 괄호 문제와 비슷하지만 차이점은 괄호의 개수가 3개로 늘어났다는 것과 문자열을 회전시킨다는 것이다.
            문자열 회전은 substring으로 잘라서 사용하지만 +연산자를 사용할 경우 시간복잡도가 크게 늘어지는 문제가 있으니
            StringBuilder을 사용하여 잘라주면 시간복잡도를 줄여줄 수 있다.
            또한 괄호의 개수가 3개이기 때문에 stack은 각 시작 괄호를 전부 담을 수 있어야 하고, 종료 괄호 문자를 만났을 때
            스택에 해당 시작 괄호가 존재하는지 확인해야 한다.
            
            현재는 각 괄호마다 if, else if를 사용하는 방식으로 갔는데, 각 종료 괄호에 해당하는 시작 괄호를 HashMap에 선언하고
            peek()와 비교하는 조건문에 hashmap.get(종료괄호) 식으로 시작괄호를 꺼내오도록 하여 비교하게 한다면
            밑의 같은 코드를 세 번씩 쓸 필요는 없게끔 할 수 있을 것 같다.
            */
            if(s.length() % 2 == 1) break; // 홀수 길이인 경우 바로 컷
            
            for(int i=0; i<sb.length(); i++) {
                char ch = sb.charAt(i);
                if(ch == '[' || ch == '(' || ch == '{') {
                    stack.push(ch);
                }
                else if(ch == '}' ) {
                    if(!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                        continue;
                    }
                    else {
                        iscorrect = false;
                        break;
                    }
                }
                else if(ch == ']') {
                    if(!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                        continue;
                    }
                    else {
                        iscorrect = false;
                        break;
                    }
                }
                else if(ch == ')') {
                    if(!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                        continue;
                    }
                    else {
                        iscorrect = false;
                        break;
                    }
                }
            }
            if(iscorrect && stack.size() == 0) answer++; // ((() 이런 식인 경우 true로 넘어가니 size로 이중 체크
        }
        
        return answer;
    }
}