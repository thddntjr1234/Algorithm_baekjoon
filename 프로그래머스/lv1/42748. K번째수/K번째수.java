import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        System.out.println(commands.length);
        int answerIndex = 0;
        for(int[] e: commands) {
            List<Integer> tmpArray = new ArrayList<>();
            for (int i=e[0]-1; i<e[1]; i++) {
                tmpArray.add(array[i]);
            }
            tmpArray.sort(Comparator.naturalOrder());
            answer[answerIndex] = tmpArray.get(e[2]-1);
            answerIndex += 1;
        }
        return answer;
    }
}