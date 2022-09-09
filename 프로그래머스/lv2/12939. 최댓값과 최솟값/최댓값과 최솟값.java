import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        int[] list = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = Arrays.stream(list).max().getAsInt();
        int min = Arrays.stream(list).min().getAsInt();
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        answer = sb.toString();
        return answer;
    }
}