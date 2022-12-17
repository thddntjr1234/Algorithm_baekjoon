import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int[] count = new int[3];

    // 이전 색종이 만들기 문제와 같지만 4개로 분할하는 것이 아닌 9개로 분할하는 것
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        Recursion(0, 0, N);

        StringBuilder sb = new StringBuilder();
        for (int n : count) {
            sb.append(n).append('\n');
        }
        
        System.out.println(sb);
    }

    static void Recursion(int row, int col, int size) {
        if (isSingleNumber(row, col, size)) {
            return;
        }

        size = size / 3;

        Recursion(row, col, size);
        Recursion(row, col+size, size);
        Recursion(row, col+size*2, size);
        Recursion(row+size, col, size);
        Recursion(row+size, col+size, size);
        Recursion(row+size, col+size*2, size);
        Recursion(row+size*2, col, size);
        Recursion(row+size*2, col+size, size);
        Recursion(row+size*2, col+size*2, size);
    }

    static boolean isSingleNumber(int row, int col, int size) {
        int num = arr[row][col];

        for (int i=row; i<row+size; i++) {
            for (int j=col; j<col+size; j++) {
                if (num != arr[i][j]) return false;
            }
        }

        count[num+1]++;
        return true;
    }
}