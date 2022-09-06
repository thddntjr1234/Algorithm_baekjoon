import java.util.*;
class Solution {
    public int[] solution(long n) {
        String[] number = Long.toString(n).split("");
        int[] answer = new int[number.length];
        int j = number.length-1;
        
        for(int i=0; i<number.length; i++) {
            answer[i] = Integer.parseInt(number[j]);
            j--;
        }
        
        return answer;
    }
}