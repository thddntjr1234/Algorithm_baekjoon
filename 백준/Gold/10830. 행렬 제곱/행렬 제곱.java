import java.util.*;
import java.io.*;

public class Main {
    
    /*
     * 행렬 곱셈 문제와 분할정복 1629 곱셈 문제를 풀었다면 두 개를 응용해 쉽게 풀 수 있다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int[][] matrix = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                // 80%에서 틀렸습니다가 나온 이유로 B가 1일때는 Recursion에서 바로 탈출되기 떄문에 1000으로 원소를 나눈 값이 들어가지 않는다
                // 만약 1000이 입력되고 지수가 1이라면 0이 아닌 1000이 그대로 출력되기 때문에 틀리는 것
                matrix[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] result = Recursion(matrix, B);
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append('\n');
        }
        
        System.out.println(sb);
    }

    /*
     * 이 재귀함수는 (N*N)행렬 A의 B승을 구하기 위한 것으로
     * 행렬의 제곱인 A^B = A^B/2 * A^B/2 공식을 이용해 맨 처음 입력된 지수 B를 2로 나눠가면서 지수가 1이 되는 시점부터
     * 행렬의 곱을 계산해서 A^2를 구하고 다시 A^4를 계산하는 방식으로 짝수 지수에 대해 행렬의 제곱을 구한다.
     * 지수가 홀수인 경우에는 A^B/2 * A^B/2 * A의 방식으로 분할해서 계산하므로
     * A^B/2 행렬을 재귀를 통해 구한 다음에는 지수가 홀수인지, 짝수인지에 따라 계산만 달리해서 결과를 반환한다.
     */
    static int[][] Recursion(int[][] matrix, long exponent) {
        if (exponent == 1) {
            return matrix;
        }

        int[][] temp = Recursion(matrix, exponent/2);

        if (exponent % 2 == 1) {
            return multiplyMatrix(multiplyMatrix(temp, temp), matrix);
        }

        return multiplyMatrix(temp, temp);
    }

    static int[][] multiplyMatrix(int[][] A, int[][] B) {
        int N = A.length;
        int M = B[0].length; // N하나만 써도 상관없음
        int K = B.length;

        int[][] result = new int[N][M];

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                for (int k=0; k<K; k++) {
                    result[i][j] = (result[i][j] + A[i][k] * B[k][j]) % 1000;
                }
            }
        }

        return result;
    }
}