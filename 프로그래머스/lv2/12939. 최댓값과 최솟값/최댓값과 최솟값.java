import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        int[] list = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = Arrays.stream(list).max().getAsInt();
        int min = Arrays.stream(list).min().getAsInt();
        
        answer = min + " " + max;
        return answer;
    }
}