import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int correct = 0, zero = 0;
        for(int i=0; i<6; i++) {
            if(lottos[i] == 0) {
                zero++;
                continue;
            }
            for(int j=0; j<6; j++) {
                if(lottos[i] == win_nums[j]) correct++;
            }
        }
        
        int[] answer = {6-(6-zero-correct), 6-(6-correct)};
        for(int i=0; i<2; i++) {
            if(answer[i] >= 2) answer[i] = 7-answer[i];
            else answer[i] = 6;
        }
        return answer;
    }
}