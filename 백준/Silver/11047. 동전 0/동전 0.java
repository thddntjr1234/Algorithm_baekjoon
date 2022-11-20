import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int[] coin = new int[N];

        // 그리디는 가장 큰 액면을 가진 동전부터 나눠가는 방식으로 최적해를 구한다.
        // 그러나 DP를 사용하지 않는 이상 그리디로 나온 결과가 최적해라고 보장할 수 없음.
        // 문제는 그리디로 최적해를 구할 수 있도록 동전의 액면을 배수가 되도록 지정했다.
        for (int i=0; i<N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        for (int i=N-1; i>=0; i--) {
            if (K / coin[i] > 0) { 
                cnt += K / coin[i];
                K -= (K / coin[i]) * coin[i];
            }
        }

        System.out.println(cnt);
    }
}