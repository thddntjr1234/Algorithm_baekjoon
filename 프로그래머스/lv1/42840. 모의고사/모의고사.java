import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[][] supoja = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        HashMap<Integer, Integer> tmpResult = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        int supojaNum = 1, max;
        
        for (int[] e: supoja) {
            int count = 0;
            for (int i=0; i<answers.length; i++) {
                if (answers[i] == e[i%e.length]) count += 1;
            }
            tmpResult.put(supojaNum, count);
            supojaNum += 1;
        }
        max = Collections.max(tmpResult.values());
        List<Integer> keySet = new ArrayList<>(tmpResult.keySet());
        Collections.sort(keySet);
        
        for (Integer key: keySet) {
            if (tmpResult.get(key) == max) {
                result.add(key);
            }
        }
        
        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}