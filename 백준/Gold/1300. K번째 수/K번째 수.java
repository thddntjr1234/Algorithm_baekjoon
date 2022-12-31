import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int N, K;
    
    /*
    이분 탐색 조건을 찾아내는 게 힘들었음
    임의의 값 mid를 1~N으로 나눈 몫(1<=n<=N)을 더한 합 sum은 mid값보다 작거나 같은 수의 개수이므로
    sum이 K보다 작다면 mid값이 너무 작은 것이므로 lo = mid+1을 해주고
    sum이 K와 같거나 K보다 크다면 mid값은 조건을 만족하기 때문에 hi값을 mid로 내려서 lower_bound 값이
    구해질 수 있도록 만족하는 첫번째 값을 찾는데, 이전 문제처럼 상한을 쓰지 않는 이유는
    목표값+1의 값이 목표값과 같은 sum값을 가지는 경우 목표값+2의 값이 결과로 반환되기 때문이다.
    이 경우 lower_bound로 접근하면 조건을 만족하는 최초의 값을 반환하게 됨
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        System.out.println(BinarySearch(K));
    }

    static int BinarySearch(int hi) {
        int lo = 1, mid = 0;

        while (lo < hi) {
            mid = (lo + hi) / 2;
            long sum = 0;

            for (int i=1; i<=N; i++) {
                sum += Math.min(N, mid / i);
            }                
            if (sum < K) {
                lo = mid + 1;
            }
            else hi = mid;
        }

        return lo;
    }
}