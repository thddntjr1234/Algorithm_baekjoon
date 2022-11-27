import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long cnt = 0; // 순서쌍 개수 카운트 변수
        int[] arr = new int[N+1];
        int[] remainder = new int[M]; // 각 누적합 배열을 M으로 나눈 나머지 

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) { // 매 누적합마다 M으로 나눈 나머지값을 대입
            arr[i] = (Integer.parseInt(st.nextToken()) + arr[i-1]) % M;
            // 0인 경우는 이미 조건을 충족하므로 바로 카운트(1-i 순서쌍의 경우를 미리 카운트 하는 것
            // 이유는 arr[1]이 나머지가 0이 아닌 경우엔 같은 나머지가 아니어서 순서쌍을 계산할 수 없다)
            if (arr[i] == 0) cnt++; 
            remainder[arr[i]]++; // remainder 배열(해당 나머지를 가지는 수의 개수)에 카운트
        }

        /*
         * n * ((n-1) / 2)는 순서를 상관하지 않는 조합의 경우의 수를 구하는 공식(n!/(n-r)!*r!)
         * 순서쌍 i, j에 대해 구하는 것이므로 remainder 배열을 순회하며 값 n에 대해 2개를 뽑는 경우의 수를 뽑아내면 된다.
         * 이 떄 순서쌍 i <= j의 관계를 가지는데 왜 순서를 고려하지 않냐면
         * 순서를 고려하고 뽑는 경우 3, 5와 5, 3이 다른 조합으로 취급되기 때문이다. 때문에 순서를 고려하지 않고 뽑아야 3, 5와 5, 3이 같은 수를 뽑은 것으로 간주할 수 있게 된다.
         */
        for (int i=0; i<M; i++) {
            int n = remainder[i];
            cnt += (long) n * (n-1) / 2; // nC2 조합 공식 적용해서 카운트에 추가
        }

        System.out.println(cnt);
    }
}