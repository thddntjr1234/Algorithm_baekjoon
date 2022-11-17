import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int i=K-1; i<N; i++) { // K일만큼 누적합을 구할 수 있는 인덱스에서부터 시작
            int sum = 0;
            for (int j=0; j<K; j++) { // K일만큼 i인덱스에서 뒤로 하나씩 더해간다
                sum += arr[i-j];
            }
            max = Math.max(sum, max); // 구한 총합을 비교해서 최대치를 저장
        }

        System.out.println(max);
    }
}