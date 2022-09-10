class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        String pre = "";
        int people = 0, cycle = 0;
        
        StringBuilder st = new StringBuilder();
        
        for(int i=0; i<words.length; i++) {
            // n로 나누어 나머지+1를 번호로 사용
            people = i%n+1;
            cycle = (i+1%n == 0) ? i/n : i/n+1;
            if(i == 0) {
                // 처음 값은 이전 값과 비교할 수 없으므로 등록만
                pre = words[i];
                // StringBuilder에 문자열 추가로 시간복잡도 줄이기(단순 +연산은 복잡도가 증가함) 
                st.append(",");
                st.append(pre);
                st.append(",");
            }
            
            // qwert가 앞에 있고 주어진 문자열이 qwe면 contains는 true를 반환하기 때문에 테케 통과가 안됨
            // 양옆에 구분자들을 전부 넣어주면 안의 문자가 부분적으로 같아도 false를 반환
            else if(st.toString().contains(","+words[i]+",")){
                // 말한 단어가 st 안에 있다면 탈락
                answer[0] = people;
                answer[1] = cycle;
                break;
            }
            else if(pre.charAt(pre.length()-1) == words[i].charAt(0)) {
                pre = words[i];
                st.append(pre);
                st.append(",");
                continue;
            }
            else {
                // 끝말잇기가 아닌 단어가 나오면 탈락
                answer[0] = people;
                answer[1] = cycle;
                break;
            }   
        }
        return answer;
    }
}