import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int size = nums.length;
        for(int i=0; i<size; i++) {
            for(int j=i+1; j<size; j++) {
                for(int k=j+1; k<size; k++) {
                    if(isPrimeNumber(nums[i]+nums[j]+nums[k])) answer += 1;
                }
            }
        }
        return answer;
    }
    public Boolean isPrimeNumber(int num) {
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i == 0) return false;
        }
        return true;
    }
}