class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strings = s.split("");
        int index = 0;
        for(String st: strings) {
            if(st.contains(" ")) index = 0;
            else index++;
            
            if(index%2 == 0) answer += st.toLowerCase();
            else answer += st.toUpperCase();
        }
        return answer;
    }
}