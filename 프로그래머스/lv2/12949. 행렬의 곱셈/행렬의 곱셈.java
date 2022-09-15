class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        /* 
        행렬의 곱은 m*k 와 k*n의 행렬이 있을 때 m*n의 행렬을 만든다
        따라서 m는 arr_m.length이고 n은 arr_n[0].length이다 
        */
        for(int i=0; i<arr1.length; i++) {
            for(int j=0; j<arr2[0].length; j++) {
                for(int k=0; k<arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}