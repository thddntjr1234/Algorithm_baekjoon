import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int num: arr) {
            if(num != min) list.add(num);
        }
        
        if(list.size() == 0) list.add(-1);
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}