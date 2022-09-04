import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        
//         /*
//         substrings 메소드만을 사용해서 풀이하였으나 ArrayList를 선언해주고 이 안에서 정렬한 뒤 맨 앞의 문
//         */
//         for(int i=0; i<strings.length; i++) {
//             strings[i] = strings[i].substring(n, n+1) 
//                 + strings[i].substring(0, n) 
//                 + strings[i].substring(n+1);
//         }
//         Arrays.sort(strings);
        
//         for(int i=0; i<strings.length; i++) {
//             strings[i] = strings[i].substring(1, n+1) 
//                 + strings[i].substring(0, 1) 
//                 + strings[i].substring(n+1);
//         }
        
        for(int i=0; i<strings.length; i++) {
            strings[i] = strings[i].charAt(n) + strings[i];
        }
        Arrays.sort(strings);
        
        for(int i=0; i<strings.length; i++) {
            strings[i] = strings[i].substring(1);
        }
        
        return strings;
    }
}