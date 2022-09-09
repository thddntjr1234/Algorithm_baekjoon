import java.util.*;
class Solution {
    public String solution(String s) {
        String[] words = s.toLowerCase().split("");
      
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<words.length; i++) {
            if(i==0) sb.append(words[i].toUpperCase());
            else if(words[i-1].equals(" ") && !words[i].equals(" ")) 
                sb.append(words[i].toUpperCase());
            else sb.append(words[i]);
        }
        
        return sb.toString();
    }
}