class Solution {
    public int solution(String s) {
        String[] stNumber = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] intNumber = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        
        for(int i=0; i<10; i++) {
            s = s.replaceAll(stNumber[i], intNumber[i]);
        }
        int answer = Integer.parseInt(s);
        return answer;
    }
}