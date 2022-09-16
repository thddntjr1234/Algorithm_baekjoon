import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        /*
        작업 진도를 일일히 계산하면서 하지 않고 미리 잔여 작업일수를 계산해 놓은 뒤
        max값을 초과하는 수를 만날 때 마다 누적한 카운트를 리스트에 넣고
        그 수를 max값으로 다시 지정해 탐색하는 방식으로 해결
        */
        for(int i=0; i<progresses.length; i++) {
            int remain = 100-progresses[i];
            if(remain%speeds[i] != 0) progresses[i] = remain / speeds[i] + 1;
            else progresses[i] = remain / speeds[i];
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        int idx = 1, cnt = 1, max = progresses[0];
        
        while(idx<progresses.length) {
            if(progresses[idx] <= max) cnt++;
            else {
                list.add(cnt);
                cnt = 1;
                max = progresses[idx];
            }
            idx++;
        }
        list.add(cnt); // while문이 정상 종료되면 마지막 작업의 개수를 마저 넣어줌
        
        int[] answer = new int[list.size()];
        idx = 0;
        for(int n : list) {
            answer[idx++] = n;
        }
        
        return answer;
    }
}