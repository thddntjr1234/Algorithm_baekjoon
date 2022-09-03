class Solution {
    public boolean solution(int x) {
        int sumOfEachNum = 0;
        boolean answer;
        
        for(char num: String.valueOf(x).toCharArray()) {
            sumOfEachNum += num-'0';
        }
        System.out.println(sumOfEachNum);
        return x%sumOfEachNum==0 ? true : false;
    }
}