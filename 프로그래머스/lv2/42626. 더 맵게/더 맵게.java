import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        /*
        힙 문제라고 분류가 되어 있기도 하지만 힙을 사용하지 않으면 매 반복마다 정렬을 해 주어야 하기 때문에 시간복잡도가 매우 증가함
        */
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int n : scoville) heap.add(n);
        
        /*
        힙 사이즈가 2이상일 때 처음 뽑은 가장 작은 수 x가 K보다 낮을 경우 다른 수 하나를 추가로 더 뽑아 음식을 섞는 루틴을 수행하고
        K보다 커서 더이상 섞을 필요가 없는 경우엔 while을 탈출한다.
        밑의 조건문에선 heap 사이즈가 1이거나, 모든 수가 K보다 같거나 큰 경우인 채로 시작하므로
        가장 작은 수 혹은 남은 한개를 뽑아 K보다 작은지 비교하고, 작다면 K이상으로 만들 수 없다는 수이므로 -1을 answer에 대입해준다.
        */
        while(heap.size() > 1) {    
            int x = heap.poll();
            if(x < K) {
                int y = heap.poll();
                answer++;
                heap.add(x+(y*2));
            }
            else break;
        }
        
        if(heap.peek() < K) answer = -1;
        
        return answer;
    }
}