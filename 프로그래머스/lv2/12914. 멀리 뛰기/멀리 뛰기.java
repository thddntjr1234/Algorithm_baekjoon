class Solution {
    public long solution(int n) {
        int[] fibo = new int[n+1];
        
        for(int i=0; i<=n; i++) {
            if(i == 0) fibo[i] = 0;
            else if(i == 1) fibo[i] = 1;
            else if(i == 2) fibo[i] = 2;
            else fibo[i] = (fibo[i-1] + fibo[i-2])%1234567;
        }
        
        return fibo[n];
    }
}