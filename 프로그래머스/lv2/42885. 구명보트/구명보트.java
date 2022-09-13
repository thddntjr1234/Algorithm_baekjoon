import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int count = 0, i = 0;
        Arrays.sort(people);
        
        /*
        최소+최대를 비교해서 차례대로 나가므로 양쪽에서 각각 줄여 나가며 비교해야 한다
        */
        for(int j=people.length-1; j>=i; j--) {
            if(people[i] + people[j] <= limit) i++;
            count++;
        }
        return count;
    }
}