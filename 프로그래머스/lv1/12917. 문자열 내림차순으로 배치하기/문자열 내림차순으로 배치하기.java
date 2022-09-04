import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] words = s.split("");
        Arrays.sort(words, Collections.reverseOrder());
        answer = String.join("",words);
        return answer;
    }
}