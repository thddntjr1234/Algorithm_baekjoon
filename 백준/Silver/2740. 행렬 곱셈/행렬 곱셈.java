import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M]; 

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] B = new int[M][K];

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<K; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        printMatrix(multiplyMatrix(A, B));
    }

    // 행렬 A, B를 입력받아 곱셈을 수행한 행렬을 반환
    static int[][] multiplyMatrix(int[][] A, int[][] B) {
        int N = A.length;
        int K = B[0].length;
        int M = B.length;
        int[][] result = new int[N][K];

        // 행렬 곱
        for (int i=0; i<N; i++) {
            for (int j=0; j<K; j++) {
                for (int k=0; k<M; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }

    // 만든 행렬을 예제 출력에 맞게 출력
    static void printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}