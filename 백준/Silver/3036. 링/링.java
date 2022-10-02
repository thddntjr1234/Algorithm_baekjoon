import java.util.*;
import java.io.*;

public class Main {
    // 유클리드 호제법을 이용한 최대공약수 계산
    public static int gcd(int num1, int num2) {
        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2); 
        while(b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // k에 대해 먼저 입력받고 배열 생성, 다음 라인은 StringTokenizer로 입력
        int k = Integer.parseInt(br.readLine());
        int[] ring = new int[k];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<k; i++) ring[i] = Integer.parseInt(st.nextToken());

        // gcd를 구한 뒤 각 값을 gcd로 나누면 몇 바퀴 도는지에 대해 분수 형태로 나타낼 수 있다.
        // 어차피 원의 지름을 구하더라도 3.14r^2은 동일하게 수행하고, 이렇게 하면 Double형으로 기약분수를 나타내야 하기 때문에 지름을 구하지 않는 것
        for(int i=1; i<k; i++) {
            int gcd = gcd(ring[0], ring[i]);
            System.out.println(ring[0]/gcd+"/"+ring[i]/gcd);
        }
    }
}