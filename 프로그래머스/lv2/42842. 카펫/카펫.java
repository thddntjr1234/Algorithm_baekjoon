class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};
    
        int i = 1, j = 0;
        
        while(true) {
            if(yellow%i == 0) {
                if(yellow/i < i) break;
                j = yellow/i;
                
                int x = j+2;
                int y = i+2;
                if(2*x + 2*(y-2) == brown) {
                    answer[0] = x;
                    answer[1] = y;
                    break;                    
                } 
            }
            i++;
            
        }
        return answer;
    }
}