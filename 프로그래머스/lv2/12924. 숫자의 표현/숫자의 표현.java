class Solution {
    public int solution(int n) {
        int answer = 0, x = 1;
        while(x <= n) {
            int sum = 0;
            for(int i=x; i<=n; i++) {
                sum += i;
                if(sum == n) {
                    answer += 1;
                    break;
                }
                else if(sum > n) break;
            }
            x++;
        }
        return answer;
    }
}