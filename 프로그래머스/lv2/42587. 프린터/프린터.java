import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> print = new LinkedList<>();
        Queue<Integer> workname = new LinkedList<>();
        /*
        작업의 우선순위를 갖는 print큐와 작업의 이름을 가진 workname큐를 각기 선언하고
        작업의 이름을 가진 workname큐는 0부터 priorities.length-1까지 수를 입력
        print큐는 priorities 배열의 값을 그대로 입력
        */
        for(int i=0; i<priorities.length; i++) workname.add(i);
        for(int p : priorities) print.add(p);
            
        while(true) {
            /*
            큐의 앞의 값을 priority 변수에 담고, print 대기열을 돌면서 자신보다 우선순위가 높은 값을 찾는다.
            만약 있다면 check = false로 만들고 밑의 check를 검사하는 if문에서 해당 작업을 큐의 맨 뒤로 옮긴다.
            없다면 해당 큐가 우선순위로 인쇄되므로 큐에서 지우고 answer++.
            차례대로 반복하여 인쇄를 요청한 문서의 차례가 오게 되면 while을 탈출하고 answer를 반환.
            */
            int priority = print.peek();
            Boolean check = true;
            for(int p : print) {
                if(priority < p) {
                    check = false;
                }
            }
            if(check) {
                answer++;
                if(workname.peek() == location) break;
                print.remove();
                workname.remove();
            }
            else {
                int a = print.peek();
                int b = workname.peek();
                workname.remove();
                print.remove();
                print.add(a);
                workname.add(b);
            }
        }
        return answer;
    }
}