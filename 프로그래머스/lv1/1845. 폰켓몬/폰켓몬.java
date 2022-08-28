import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> ponketmonList = new HashSet<>();
        int howmany = nums.length/2;
        int answer = 0;
        
        for(int e: nums) {
            ponketmonList.add(e);
        }
        
        if(howmany > ponketmonList.size()) answer = ponketmonList.size();
        else answer = howmany;
        
        return answer;
    }
}