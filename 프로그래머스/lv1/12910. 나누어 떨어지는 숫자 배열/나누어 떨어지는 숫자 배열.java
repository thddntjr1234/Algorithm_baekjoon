import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for(int element: arr) {
            if(element%divisor == 0) {
                result.add(element);
                count++;
            }
        }
        if(count == 0) result.add(-1);
        
        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        return answer;
    }
}