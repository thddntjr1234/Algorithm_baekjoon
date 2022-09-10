class Solution {
    public int solution(int n) {
        long[] fibo = new long[n+1];
        long num = 1234567;
        for(int i=0; i<=n; i++) {
            if(i==0) fibo[i] = 0;
            else if(i==1) fibo[i] = 1;
            else fibo[i] = fibo[i-1]%num + fibo[i-2]%num;
        }
        
        int answer = (int)(fibo[n] % 1234567);
        return answer;
    }
}