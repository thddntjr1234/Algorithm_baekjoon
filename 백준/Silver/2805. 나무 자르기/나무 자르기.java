import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        long hi = 0;
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > hi) hi = arr[i]; 
        }

        System.out.println(binarySearch(hi));
    }

    // upper_bound로 구현한 이분 탐색
    static long binarySearch(long hi) {
        long lo = 0;
        hi++;

        while (lo < hi) {
            long mid = (lo+hi) / 2;
            long remain = 0;
            
            for (int i=0; i<N; i++) {
                if (arr[i] - mid >= 0) remain += arr[i] - mid;  
            }

            if (remain < M) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo - 1;
    }
}