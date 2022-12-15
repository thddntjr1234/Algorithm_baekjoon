import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int white = 0, blue = 0;

    /*
     * 분할 정복은 문제 n에 대해서 작은 문제 n1, n2, n3 .. 으로 분할하고
     * 이를 각각 분할한 문제 m1, m2, m3 ...으로 분할해 가며 푸는 것으로
     * 재귀를 사용하면 딱이다
     */
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        Recursion(0, 0, N); // 첫 한장에 대해서 재귀 시작

        System.out.println(white);
        System.out.println(blue);
    }

    static boolean checkColor(int row, int col, int size) {
        int color = arr[row][col]; // 가장 처음 배열의 색을 타겟으로 
        for (int i=row; i<row+size; i++) {
            for (int j=col; j<col+size; j++) {
                if (arr[i][j] != color) return false; // 다른 색이 나오면 false 리턴
            }
        }
        return true; // 모든 for문이 정상 종료된다면 색종이 조건을 만족하므로 true 리턴
    }

    static void Recursion(int row, int col, int size) {
        if (checkColor(row, col, size)) {
            if (arr[row][col] == 0) white++;
            else blue++; 
        }
        
        else {
            size = size / 2; // 반으로 분할
            // 분할한 면 4개에 대해서 재귀를 수행
            Recursion(row, col, size); // 왼쪽 위
            Recursion(row+size, col, size); // 오른쪽 위
            Recursion(row, col+size, size); // 왼쪽 아래
            Recursion(row+size, col+size, size); // 오른쪽 아래
        }
    }
}