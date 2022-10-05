import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), cnt = 0;
        BigInteger sum =  new BigInteger("1");
        // n!을 구하고
        for(int i = n; i>1; i--) {
            sum = sum.multiply(BigInteger.valueOf(i));
        }
        // 10으로 나누면서 나머지가 0이 아닐 때까지 나눠간다.
        BigInteger divide = new BigInteger("10");
        BigInteger zero = new BigInteger("0");
        while(true) {
            // BigInteger는 equals가 문자열을 대상으로 비교하는 것이 아니라 같은 BigInteger 객체를 비교하는 것
            if(sum.remainder(divide).equals(zero)) {
                cnt++;
                sum = sum.divide(divide);
            }
            else break;
        }
        System.out.println(cnt);

        /*
         * 이 방법 외에도 소인수분해를 통해서도 계산할 수 있는데, 2와 5가 곱해져야만 뒷자리에 0이 붙는다는 것을 이용하여
         * 주어진 n을 5로 나눈다. 이 때 n의 5의 제곱이라면, 5가 지수만큼 추가로 있는 것으로 가정해서 추가로 카운트해야한다.
         * 때문에 
         * while(n >= 5) {
         *     cnt += n / 5;
         *     n /= 5;
         * }
         * 로 지수에 대한 계산도 같이 해주면 된다.
         * 예시로 25일 때 지수는 k = 2이며 cnt는 처음으로 5가 되고, 여기에 5의 2승이기 때문에 n을 5로 나누어주면 5^k-1인 상태가 된다.
         * 5^1에 대해 다시 cnt에 추가해 주면 n은 다시 나누어져 1이 되고 while을 탈출하게 되어 cnt는 6이 된다.
        */
    }
}