class Solution {
    public int solution(int n) {
        int answer = 0;
        String ternary = "";
        
        // 3진법 변환
        while(true) {
            // 만약 정상적인 3진법 변환을 하려면 ternary = n%3 + ternary를 하면 됨
            ternary += n%3;
            n/=3;
            if(n == 0) break;
        }
        // 10진법 변환
        String[] numberOfTernary = ternary.split("");
        for(int i=0; i<numberOfTernary.length; i++) {
            answer += Integer.parseInt(numberOfTernary[i]) * Math.pow(3, (numberOfTernary.length-1)-i);
        }
        
        return answer;
    }
}