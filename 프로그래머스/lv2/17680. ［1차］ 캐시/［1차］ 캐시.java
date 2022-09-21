import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> list = new ArrayList<>();
        
        for(String st : cities) {
            st = st.toLowerCase();

            if(cacheSize == 0) {
                answer = 5 * cities.length;
                break;
            }

            if(list.size() < cacheSize && !list.contains(st)) {
                list.add(st);
                answer += 5;
            }
            else if((list.size() >= cacheSize || list.size() < cacheSize) && list.contains(st)) {
                list.remove(list.indexOf(st));
                list.add(st);
                answer += 1;
            }
            else if(list.size() >= cacheSize && !list.contains(st)) {
                list.remove(0);
                list.add(st);
                answer += 5;
            }
        }
        return answer;
    }
}