class Solution {
    public int[] solution(int[] prices) {
        //스택으로 풀어야 할 것 같은데 이중for문으로도 가능할 것 같아서 풀이함
        int[] answer = new int[prices.length];
        
        for(int i=0; i<prices.length; i++) {
            if(i == prices.length-1) answer[i] = 0;
            else {
                for(int j=i+1; j<prices.length; j++) {
                    if(j == prices.length-1 || prices[i] > prices[j]) {
                        answer[i] = j-i;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}