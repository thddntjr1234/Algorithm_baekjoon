class Solution {
    public int solution(int n) {
        String ternary = "";
        
        // 3진법 변환
        while(true) {
            // 만약 정상적인 3진법 변환을 하려면 ternary = n%3 + ternary를 하면 됨
            ternary += n%3;
            n/=3;
            if(n == 0) break;
        }
        // Integer.parseInt(String) == Integer로 단순 변환
        // Integer.parseInt(String, Int) == int변수의 값에 해당하는 진법으로 변환
        return Integer.parseInt(ternary, 3);
    }
}