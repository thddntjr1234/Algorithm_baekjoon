class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        char[] words = s.toCharArray();
        
        if(s.length() == 4 || s.length() == 6) {
            for(char each: words) {
                if(each < 48 || each > 57) {
                    answer = false;
                    break;
                }
            }
        }
        else answer = false;
        return answer;
    }
}