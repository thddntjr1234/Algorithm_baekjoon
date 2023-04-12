import java.util.*;

class Solution {
    public int[] solution(int n) {  
        int[][] arr = new int[n][n];
        int num = 1;
        
        int x = 0;
        int y = 0;
        
        while(true) {// 1. 아래로 이동
            while (true) {
                arr[y][x] = num++;
                
                if (y + 1 == n || arr[y+1][x] != 0) break;
                
                y += 1;
            }
            if (x + 1 == n || arr[y][x+1] != 0) break;
            x += 1;
            
            // 2. 오른쪽으로 이동
            while (true) {
                arr[y][x] = num++;
                
                if (x + 1 == n || arr[y][x+1] != 0) {
                    System.out.println("오른쪽 " + x + ", " + y);
                    break;
                }
                
                x += 1;
            }
            if (arr[y-1][x-1] != 0) break;
            x -= 1;
            y -= 1;
            
            // 3. 좌상단 대각선 이동
            while (true) {
                arr[y][x] = num++;
                
                if (arr[y-1][x-1] != 0) {
                    break;
                }
                
                x -= 1;
                y -= 1;
            }
            if (y + 1 == n || arr[y+1][x] != 0) break;
            y += 1;
        }
        
        int[] answer = new int[num-1];
        int i = 0;
        
        for (int[] e: arr) {
            for (int number: e) {
                if (number != 0) answer[i++] = number;
            }
        }
        
        return answer;
    }
}