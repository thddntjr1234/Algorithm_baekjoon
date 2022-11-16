import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];

        // arr에 두번째 줄에 주어진 값 입력
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i=1; i<=N; i++) {
            sum += Integer.parseInt(st.nextToken());
            arr[i] = sum;
        }

        // 세번쨰 줄 부터 입력된 i, j에 대해 누적합을 출력
        for (int k=0; k<M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            // j까지의 누적합 - i-1까지의 누적합 = i부터 j까지의 누적합이 된다
            System.out.println(arr[j] - arr[i-1]);
        }
    }
}