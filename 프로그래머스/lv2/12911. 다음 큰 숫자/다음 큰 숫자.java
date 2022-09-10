import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = n+1;
        while(true) {
            if(Integer.bitCount(answer) == Integer.bitCount(n)) break;
            else answer++;
        }
        
        return answer;
    }
}