import java.util.*;
class Solution {
    public int[] solution(String s) {
        

        // 각 튜플별로 HashMap에 저장
        HashMap<Integer, String[]> map = new HashMap<>();
        String[] ss = s.split("");
        
        int cnt = 0, idx = 0;
        /*
        {를 만나면 문자열 자르는 데 사용하는 idx변수 값을 현위치로 초기화시키고
        숫자 갯수를 카운트하는 cnt변수 값은 1로 세팅함(튜플의 최소 원소는 1개부터이므로)
        }를 만나면 idx부터 }문자 이전까지 문자열을 잘라서 map에 숫자 개수와 함께 저장
        쉼표는 숫자 개수가 여러개일 때 사용하니 ,한개당 숫자 하나가 추가된다고 할 수 있음
        */
        for(int i=0; i<s.length(); i++) {
            if(ss[i].equals("{")) {
                idx = i;
                cnt = 1;
            }
            else if(ss[i].equals("}")) {
                if(!ss[i-1].equals("}")){
                    String[] st = s.substring(idx+1, i).split(",");
                    map.put(cnt, st);                    
                }
            }
            else if(ss[i].matches(",")){
                cnt++;
            }
        }
        
        /*
        LinkedHashSet은 순서를 보장하는 중복 제거 자료구조이므로 keySet으로 오름차순별로 key를 가져오고
        forEach를 사용해 원소 개수가 1부터인 튜플의 원소들을 차례대로 set에 대입해준다
        */
        Set<Integer> result = new LinkedHashSet<>();
        for(Integer key : map.keySet()) {
            String[] st = map.get(key);
            for(String n : st) {
                result.add(Integer.parseInt(n));
            }
        }
        
        // set은 Integer형이므로 int배열에 맞게 변환해서 대입해주고 반환하면 끝
        int[] answer = new int[result.size()];
        idx = 0;
        for(Integer num : result) answer[idx++] = num;
        return answer; 
    }
}