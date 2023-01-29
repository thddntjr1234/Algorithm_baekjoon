import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> arr = new LinkedList<>();
        
        /*
        주어진 배열을 그대로 활용한다고 할 때
        순서는 1-2-3-1 순서임을 발견할 때 까지 인덱스를 증가시키며 연결리스트를 탐색하다가 탐색에 성공하면
        해당 인덱스 값 삭제를 총 4번 수행한다(연결리스트는 노드 방식이기 때문에 삭제하게 되면 그만큼 줄어들기 때문)
        이후 i값을 다시 0부터 시작하도록 -1(i++ 고려)로 초기화하고 반복문을 다시 실행시키게 한다.
        만약 반복문이 종료된다면 더이상 만들 수 있는 햄버거가 없는 것이므로 answer을 반환한다.
        
        첫번째 시도(실패) - 연결 리스트에 값을 모두 입력하고 수행했기 때문에 매 삭제마다 모든 노드에 대해 인덱스를 새로 수정하느라 시간초과 발생
        */
        for (int i = 0; i < ingredient.length; i++) {
            arr.add(ingredient[i]);
            
            if (arr.size() >= 4) {
                int size = arr.size();
                if (arr.get(size-1) == 1 && arr.get(size-2) == 3 && arr.get(size-3) == 2 && arr.get(size-4) == 1) {
                    arr.remove(size-1);
                    arr.remove(size-2);
                    arr.remove(size-3);
                    arr.remove(size-4);
                    answer++;
                }
            }
        }
        
        return answer;
    }
}