import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String str : babbling) {
            String beforeString = "";
            int start = 0;
            boolean isPossible = false;
            
            for (int i = 1; i<=str.length(); i++) {
                String substring = str.substring(start, i);

                if (isContains(substring) && !substring.equals(beforeString)) {
                    beforeString = substring;
                    start = i;
                    isPossible = true;
                }
                
                else {
                    isPossible = false;
                }
                
            }
            
            if (isPossible) {
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isContains(String str) {
        String[] word = {"aya", "ye", "woo", "ma"};
        
        for (int i=0; i<4; i++) {
            if (str.equals(word[i])) {
                return true;
            }
        }
        
        return false;
    }
}