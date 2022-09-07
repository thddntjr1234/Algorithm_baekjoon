import java.util.*;
class Solution {
    public int solution(String dartResult) {
        char[] input = dartResult.toCharArray();
        int index = -1, answer = 0;
        int[] scoreOfRound = new int[3];
        String score = "";

        for(int i=0; i<input.length; i++) {
            char ch = input[i];
            // 해당 문자가 숫자면 score문자열에 추가해 나간다.
            // 10인 경우를 따로 조건에 달지 않아도 됨
            if(ch >= '0' && ch <= '9') score += Character.toString(ch);
            else if(ch == 'S' || ch == 'D' || ch == 'T') {
                //보너스 문자는 각 라운드마다 무조건 한 개씩 나오기 때문에 인덱스를 이 때 증가시킨다.
                //-1에서 ++로 증가시키지 않고 0부터 시작하면 이후 나오는 옵션에서 index에 -1, -2하는 방식으로 접근해야 함
                int exponent = 0;
                index++;
                if(ch == 'S') exponent = 1;
                else if(ch == 'D') exponent = 2;
                else exponent = 3;    
                
                scoreOfRound[index] = (int)Math.pow(Integer.parseInt(score), exponent);
                //이후 옵션에서의 점수 계산은 배열 scoreOfRound에서 다루므로 문자열을 초기화시켜 잘못된 값이 들어가지 않도록 함
                score = "";
            }
            
            else if(ch == '*' || ch == '#') {
                if(ch == '*') {
                    // 맨 처음에 *옵션이 나올 경우의 조건
                    if(index==0) scoreOfRound[index] *= 2;
                    else {
                        scoreOfRound[index-1] *= 2;
                        scoreOfRound[index] *= 2;
                    }
                }
                else {
                    // 점수를 차감하는 방식이므로 -연산자를 붙여줌. 이후 다음 인덱스에서 *옵션이 나올 시
                    // 자동으로 -값을 두배로 만듬
                    scoreOfRound[index] *= -1;
                }
            }
        }
        answer = scoreOfRound[0] + scoreOfRound[1] + scoreOfRound[2];
        return answer;
    }
}