import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        
        int tmp = arr[0];
        List<Integer> tmpResult = new ArrayList<>();
        tmpResult.add(tmp);
        
        for (int i=1; i<arr.length; i++) {
            if (arr[i] != tmp) tmpResult.add(arr[i]);
            tmp = arr[i];
        }
        
        int[] answer = new int[tmpResult.size()];
        for (int i=0; i<tmpResult.size(); i++) {
            answer[i] = tmpResult.get(i);
        }
        
        
        return answer;
    }
}