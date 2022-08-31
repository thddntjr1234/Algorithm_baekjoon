import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> tmpResult = new HashSet<>();
        
        for (int i=0; i<numbers.length; i++) {
            for (int j=i+1; j<numbers.length; j++) {
                tmpResult.add(numbers[i]+numbers[j]);
            }
        }
        
        int[] result = tmpResult.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(result);
        return result;
    }
}