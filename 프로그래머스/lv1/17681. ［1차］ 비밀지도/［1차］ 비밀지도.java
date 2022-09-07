class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        String[] answer = new String[result.length];
        // result int array에 bitwise or 하여 저장
        for(int i=0; i<result.length; i++) {
            result[i] = arr1[i] | arr2[i];
        }
        for(int i=0; i<result.length; i++) {
            String binary = "";
            int num = result[i];
            // 2진법 변환한 나머지를 문자열에 더하고
            while(num>0) {
                binary = num%2 + binary;
                num /= 2;
            }
            
            
            
            binary = "0".repeat(n-binary.length()) + binary;
            //1은 #으로 0은 공백으로 치환
            binary = binary.replaceAll("1", "#");
            binary = binary.replaceAll("0", " ");
            answer[i] = binary;
        }

        return answer;
    }
}