class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10, right = 12;
        int distByLeft = 0, distByRight = 0;
        
        for(int num : numbers) {
            if(num == 2 || num == 5 || num == 8 || num == 0) {
                if(num==0) num = 11;
                distByLeft = Math.abs(num-left)/3 + Math.abs(num-left)%3;
                distByRight = Math.abs(num-right)/3 + Math.abs(num-right)%3;
                if(distByLeft < distByRight) {
                    answer += "L";
                    left = num;
                }
                else if(distByLeft > distByRight) {
                    answer += "R";
                    right = num;
                }
                else {
                    if(hand.equals("right")) {
                        answer += "R";
                        right = num;
                    }
                    else {
                        answer += "L";
                        left = num;
                    }
                }
            }
            else if(num == 3 || num == 6 || num == 9){
                answer += "R";
                right = num;
            }
            else if(num == 1 || num == 4 || num == 7) {
                answer += "L";
                left = num;
            }
        }
        
        return answer;
    }
}