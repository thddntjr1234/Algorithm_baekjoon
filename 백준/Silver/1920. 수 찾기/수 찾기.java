import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 이진 탐색 전 오름차순 정렬을 수행

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            int target = Integer.parseInt(st.nextToken());
            
            if (binarySearch(arr, target)) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }

        System.out.println(sb);
    }

    /*
     * 반복문으로 이진 탐색을 수행
     * 성공한 경우 true를 리턴하지만
     * 가장 마지막 실행의 경우 low, high가 같은 인덱스를 가지게 되므로
     * 여기서도 탐색에 실패한다면 low값은 반드시 high를 초과하게 됨
     * 이 경우 while이 끝나고 false 을 리턴
     */
    static boolean binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length-1;

        while (low <= high) {
            int mid = (low+high) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }    
}