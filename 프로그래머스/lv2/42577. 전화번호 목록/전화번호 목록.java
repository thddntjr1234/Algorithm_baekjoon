import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        //String에서의 sort는 사전 순으로 문자열을 정렬한다.
        // 1234 123 1000 -> 1000 123 1234순으로 정렬됨
        Arrays.sort(phone_book);
        
        // sort한 phone_book은 앞뒤로 한번씩만 비교하면 되므로 정렬하지 않았을 때 O(n^2)에 비해 O(20(전화번호 최대길이)*n)의 시간복잡도를 가짐
        for(int i=1; i<phone_book.length; i++) {
            if(phone_book[i].startsWith(phone_book[i-1])) {
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}