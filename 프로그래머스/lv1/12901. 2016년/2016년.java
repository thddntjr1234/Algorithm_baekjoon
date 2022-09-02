class Solution {
    public String solution(int a, int b) {
        int[] dayOfMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayOfWeek = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int day = 0;
        for(int i=0; i<a-1; i++) {
            day += dayOfMonth[i];
        }
        day += b-1;
        
        
        String answer = String.format("%s", dayOfWeek[day%7]);
        return answer;
    }
}