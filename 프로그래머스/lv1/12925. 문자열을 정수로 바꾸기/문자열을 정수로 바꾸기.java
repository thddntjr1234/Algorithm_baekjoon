import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        Boolean signbit = false;
        
        if(s.charAt(0) == '-') {
            s = s.substring(1);
            signbit = true;
        }
        else if(s.charAt(0) == '+') {
            s = s.substring(1);
        }
        
        for(int i=0; i<s.length(); i++) {
            answer += (s.charAt(i)-'0') * Math.pow(10, s.length()-i-1);
        }
        
        if(signbit) answer = -answer;
        
        return answer;
    }
}