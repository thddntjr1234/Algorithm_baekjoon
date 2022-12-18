import java.util.*;
import java.io.*;

public class Main {

    static int K, N;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[] arr =  new int[K];
        long high = 0;
        for (int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > high) high = arr[i];
        }

        System.out.println(binarySearch(arr, high));
    }

    static long binarySearch(int[] arr, long high) {
        // 상한식 이분탐색
        long low = 0;
        high++;

        while (low < high) {
            int cnt = 0;
            long mid = (low+high) / 2;

            for (int i=0; i<K; i++) {
                cnt += arr[i] / mid;
            }

            if (cnt < N) high = mid;
            // 만약 mid값에 대해서 cnt >= N을 만족했는데 mid+1값을 low로 넣었을 떄 while의 조건에 부합해서 루프가 종료되면 
            // 해당 값이 상한으로 구한 값이므로 return할 때는 low값에 다시 1을 빼서 리턴한다.
            else low = mid + 1; 
        }

        return low - 1;
    }
}