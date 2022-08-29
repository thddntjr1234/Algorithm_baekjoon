import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int[] existNumber = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};        
        int answer = 0;
        
        for (int number: numbers) existNumber[number] = 0;
        answer = Arrays.stream(existNumber).sum();
        
        return answer;
    }
}