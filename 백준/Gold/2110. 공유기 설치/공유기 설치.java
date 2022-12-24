import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int N, C;

    /*
     * 랜선 자르기, 나무 자르기 문제와 동일
     * 중간 if문에서 key값이 유효한지 검사하는 부분만 다름, 랜선과는 다르게 low, high가 둘다 0일 수 없기 떄문에 hi++를 하지 않는다
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr); // 좌표를 무작위로 주었기 때문에 오름차순 정렬 수행

        System.out.println(BinarySearch(arr[N-1]));
    }

    static int BinarySearch(int hi) {
        int lo = 0, mid = 0;

        while (lo < hi) {
            mid = (lo + hi) / 2;

            if (isPossible(mid)) {
                lo = mid + 1;
            }
            else hi = mid;
        }

        return lo - 1;
    }

    static boolean isPossible(int range) {
        int cnt = 1;
        int prevPos = 0;

        for (int i=1; i<N; i++) {
            if (arr[i] - arr[prevPos] >= range) {
                cnt++;
                prevPos = i;
            }
        }

        if (cnt >= C) return true;
        return false;
    }
}