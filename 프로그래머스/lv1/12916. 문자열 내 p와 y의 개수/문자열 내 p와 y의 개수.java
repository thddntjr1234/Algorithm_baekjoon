class Solution {
    boolean solution(String s) {
        int pCount = 0, yCount = 0;
        char[] words = s.toCharArray();
        for(char word: words) {
            if(word == 'p' || word == 'P') pCount += 1;
            else if(word == 'y' || word == 'Y') yCount += 1;
        }

        return (pCount == yCount) ? true : false;
    }
}