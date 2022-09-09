class Solution {
    public int[] solution(String s) {
        int count = 0, zero = 0;
        while(s.length()>1) {
            // 사라진 0 개수를 문자열 길이로 판단
            int tmp = s.length();
            s = s.replaceAll("0", "");
            zero += tmp - s.length();
            
            int c = s.length();
            s = "";
            // c에 대해 2진법 변환한 결과를 result에 담는다
            while(true) {
                s = c%2 + s;
                c = c/2;
                if(c==0) break;
            }
            count += 1;
        }
        
        return new int[] {count, zero};
    }
}