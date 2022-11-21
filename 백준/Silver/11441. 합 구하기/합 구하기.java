import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) { // 배열에 누적합을 저장
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
        }

        int M = Integer.parseInt(br.readLine());
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (start == 1) sb.append(arr[end]).append('\n');
            else sb.append(arr[end] - arr[start-1]).append('\n');
        }

        System.out.println(sb);
    }
}