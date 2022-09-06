import java.util.*;
class Solution {
    public String solution(String s, int n) {
        /*
        n이 만약 26이상인 경우에는 위 방식으로 해결이 불가능하므로 밑의 수식을 사용해야함
        for(int i=0; i<s.length(); i++) {
              char ch = s.charAt(i);
              
              if(Character.isLowerCase(ch)) { //소문자
                  ch = (char) ((ch - 'a' + n) % 26 + 'a');
              } else if(Character.isUpperCase(ch)) { //대문자
                  ch = (char) ((ch - 'A' + n) % 26 + 'A');
              }
              
              answer += ch;
          }
        */
        String answer = "";
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isLowerCase(ch)) {
                if(ch+n <= 'z') ch += n;
                else ch += n-26;
            }
            else if(Character.isUpperCase(ch)) {
                if(ch+n <= 'Z') ch += n;
                else ch += n-26;
            }
            answer += ch;
        }
        return answer;
    }
}