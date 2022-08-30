class Solution {
    public int solution(int intnum) {
        long num = intnum;
        int count = 0;
        
        if (num == 1) return 0;
        
        while (count<500) {
            if (num == 1) break;
            
            if (num%2 == 0) num = num/2;
            else num = num*3+1;
            count += 1;
        }
        if (num != 1) return -1;
        return count;
    }
}