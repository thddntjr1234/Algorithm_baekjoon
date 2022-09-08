import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] success = new int[N];
        int[] total = new int[N];
        HashMap<Integer, Double> result = new HashMap<>();
        
        //전체시도횟수
        for(int i=0; i<stages.length; i++) {
            for(int j=0; j<stages[i]; j++) {
                if(j<N) total[j] += 1;
            }
        }
        //성공횟수
        for(int i=0; i<stages.length; i++) {
            for(int j=0; j<stages[i]-1; j++) {
                if(j<N) success[j] += 1;
            }
        }
        //실패율계산
        for(int i=0; i<total.length; i++) {
            result.put(i+1, (double) success[i] / total[i]);   
        }
        
        List<Integer> li = new ArrayList<>(result.keySet());
        Collections.sort(li, (o1, o2) -> Double.compare(result.get(o1), result.get(o2)));
        
        return li.stream().mapToInt(Integer::intValue).toArray();
    }
}