class Solution {
    public int solution(int[][] sizes) {
        int w = 0, h = 0;
        int max, min;
        for (int[] e:sizes) {
            max = Math.max(e[0], e[1]);
            min = Math.min(e[0], e[1]);
            
            if (max > w) w = max;
            if (min > h) h = min;
        }
        
        int answer = w * h;
        return answer;
    }
}