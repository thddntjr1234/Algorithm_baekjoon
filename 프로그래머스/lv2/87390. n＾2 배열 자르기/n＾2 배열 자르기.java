import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        int idx = 0;
        
        /*
        반성이 많이 되는 문제, 맨 처음엔 조건대로 n행 n열의 배열을 만들고, i로 채운 뒤 잘라내고 새로운 배열을 만들어서 저장하려고 했음
        그러나 n^2크기는 배열의 크기가 감당할 수 없고, 되더라도 시간 복잡도가 매우 높음
        때문에 2차원 배열을 1차원으로 나열할 때 1차원 배열에서의 인덱스를 2차원 내부배열의 크기로 나눈다면
        배열의 원소 최대 크기가 n까지인 경우에 한해
        나머지+1는 행의 인덱스로, 몫+1는 열의 인덱스로 사용할 수 있게 된다.
        */
        for(long i=left; i<=right; i++) {
            answer[idx++] = Math.max((int)(i%n)+1, (int)(i/n)+1);
        }
        return answer;
    }
}