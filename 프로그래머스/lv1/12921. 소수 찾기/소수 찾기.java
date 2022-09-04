class Solution {
    public int solution(int n) {
        int answer = 0, check = 0;
        for(int i=2; i<=n; i++) {
            check = 1;
            for(int j=2; j<=Math.sqrt(i); j++) {
                if(i%j == 0) {
                    check = 0;
                    break;
                }
            }
            if(check==1) answer += 1;
        }
        return answer;
    }
}