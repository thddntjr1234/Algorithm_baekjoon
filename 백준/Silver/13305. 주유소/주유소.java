import java.util.*;
import java.io.*;

public class Main {
    /*
     * 각 도시를 들리면서 최소 비용으로 가기 위해서는 들린 주유소의 기름 값과 다음에 만나는 주유소의 기름값을 비교해서 주유해야 한다.
     * 여기서 실제 주유하는 것처럼 다음에 얼마나 주유해야 할 지 계산하고 이동하는 거로 코딩한다면 복잡하기 때문에
     * minCost라는 최솟값 변수를 두고 이 minCost 변수의 최솟값이 갱신되기 전 까지 매 도시마다 minCost * range[i]로 계산해서 
     * 결과값에 더해 준다면 다음 최솟값 비용을 가진 주유소를 만날 때 까지 최소 비용으로 주유한 셈이 된다.
     * 즉 예제처럼 2 - 3 - 1 거리의 A, B, C, D 도시에 대해서
     * 처음에 주유해야 하는 최소 비용인 5 * 2(거리)값을 수행한 이후엔
     * B도시의 기름값이 2/L이므로 minCost = 2로 갱신되고
     * D도시에 도착할 때 까지 minCost가 갱신되지 않으므로 (B-C 거리인 3 + C-D거리인 1) * 2를 결과에 더한 값이 최소 비용이 된다.
     */
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] range = new long[N];
        long[] cost = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N-1; i++) {
            range[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        long minCost = cost[0];
        long result = 0;
        for (int i=0; i<N-1; i++) {
            if (minCost < cost[i]) {
                result += range[i] * minCost; 
            }
            else {
                minCost = cost[i];
                result += range[i] * minCost;
            }
        }

        System.out.println(result);
    }
}