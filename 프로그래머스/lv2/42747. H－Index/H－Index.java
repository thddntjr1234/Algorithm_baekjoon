import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int hindex = 0;
        Arrays.sort(citations);
                
        for(int i=1; i<=citations[citations.length-1]; i++) {
            int temp = 0;
            
            for(int j=0; j<citations.length; j++) {
                if(i <= citations[j]) temp++;
            }
            if(temp >= i && i > hindex) hindex = i;
        }
        return hindex;
    }
}