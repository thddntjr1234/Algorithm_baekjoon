import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr = new int[9][9];
    static StringBuilder sb;
    public static boolean checkValidation(int row, int col, int value) {
        // 행, 열 대상으로 중복되는 값 조회
        for (int i=0; i<9; i++) {
            if (arr[row][i] == value || arr[i][col] == value) return false;
        }
        
        // 3x3 스도쿠에서 중복되는 값 조회
        // (row/3)*3 은 3x3 스도쿠의 시작할 행 위치임, 열도 동일 ex) row가 5면 몫*3 = 3이 row가 있는 스도쿠의 처음 행 위치가 됨
        for (int i=(row/3)*3; i<(row/3)*3+3; i++) {
            for (int j=(col/3)*3; j<(col/3)*3+3; j++) {
                if (arr[i][j] == value) return false;
            }
        }

		return true; // 중복되는 수가 없으므로 true를 리턴
    }

    public static void dfs(int row, int col) {
        if (row == 9) { // row가 9까지 도달하면 스도쿠를 완성한 것
            sb = new StringBuilder(); // 결과 배열을 출력하기 위해 사용
            for (int i=0; i<9; i++) {
                for (int j=0; j<9; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append('\n');
            }

            System.out.println(sb);
            System.exit(0);
        }

        if (col == 9) { // 한 행에서의 분기를 끝냈으므로 다음 행에서 탐색후 분기 시작
            dfs(row+1, 0);
            return;
        }

        // 0인 숫자에 대해서 스도쿠 조건을 만족하는 수를 1부터 9까지 검증해가며 찾음
        if (arr[row][col] == 0) {
            for (int i=1; i<=9; i++) {
                if (checkValidation(row, col, i)) {
                    arr[row][col] = i; // 사용 가능한 수이므로 배열에 넣고
                    dfs(row, col+1); // 다음 열로 이동해 계속 분기함
                }
            }
            // 모든 분기가 끝났으면 다음 분기를 위해 0이없던 값을 초기로 되돌려주는데, 이렇게 하지 않으면 다음 분기에서 제대로 작동할 수 없음
            // ex) 0 0인 첫번째 행에 에 1, 9가 들어갔음, 이 분기가 스도쿠가 아니어서 배제된 경우엔 다음 분기가 실행될 때 1, 9가 들어가 있어 다른 분기에서 제대로 수행할 수 없다.
            // 그래서 0으로 초기화 해 주는 것
            arr[row][col] = 0; 
            return;
        }
        else dfs(row, col+1); // 0이 아닌 수는 건너뜀
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, 0);
    }
}