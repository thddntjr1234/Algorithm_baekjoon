import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][N+1];

        for (int i=1; i<=N; i++) { // 배열에 누적합을 행별로 저장
            st = new StringTokenizer(br.readLine());

            for (int j=1; j<=N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i][j-1];    
            }
        }    
        

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sum = 0;

            // 1차원 배열에서의 누적합 계산식
            for (int j=x1; j<=x2; j++) {
                sum += arr[j][y2] - arr[j][y1-1];
            }
            sb.append(sum).append('\n');
        }

        System.out.println(sb);
    }
}