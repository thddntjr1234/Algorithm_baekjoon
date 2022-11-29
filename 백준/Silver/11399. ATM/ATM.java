import java.util.*;
import java.io.*;

public class Main {
    /*
     * 이전 회의실 배정 문제보다 더 쉬운 문제로 OS에서의 SJF 스케쥴링 알고리즘과 비슷함
     */
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // SJF를 써주기 위해 오름차순 정렬
        int sum = 0, result = 0;
        for (int i=0; i<N; i++) {
            sum += arr[i];
            result += sum;
        }

        System.out.println(result);
    }
}