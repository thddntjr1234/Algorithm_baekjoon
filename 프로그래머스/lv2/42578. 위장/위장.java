import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> wear = new HashMap<>();
        
        /*
        해시를 이용하면 비교적 쉬운 문제, 문자열을 일일히 비교에 변수를 만들 수도 없고, 배열에 각기 다른 값을 저장할 수도 없기 때문에
        해시를 이용하여 주어지는 옷의 종류를 키값으로 사용하고, 옷의 개수를 해시의 값으로 사용한다면 무작위로 옷을 줘도 종류별로 카운트 가능함
        경우의 수는 옷을 입지 않은 경우도 고려하므로 같은 종류의 옷을 두개 줘도 경우의 수는 3으로 고려해야 함.
        */
        for(String[] arr : clothes) {
            if(wear.containsKey(arr[1])) wear.put(arr[1], wear.get(arr[1])+1);
            else wear.put(arr[1], 1);
        }
        
        // HashMap 키를 순회하면서 wear의 크기가 1이 아니면 안 입은 경우의 수도 고려하여 +1하여 answer에 곱함
        // 크기가 1이면 고려할 경우의 수는 wear의 value임
        for(String key : wear.keySet()) {
            if(wear.size() == 1) return wear.get(key);
            answer *= wear.get(key)+1;
        }
        answer -= 1; // 아예 안입은 경우의 수는 제외
        return answer;
    }
}