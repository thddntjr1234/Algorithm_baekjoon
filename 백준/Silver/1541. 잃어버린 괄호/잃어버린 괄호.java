import java.util.*;
import java.io.*;

public class Main {
    /*
     * 각 기호별로 분리해서 풀어야 했지만 푸는 방법에 익숙하지 않아서 풀이를 참고함
     */
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer minus = new StringTokenizer(br.readLine(), "-");
        int result = Integer.MAX_VALUE; // 첫 수인지를 확인하기 위한 용도

        while (minus.hasMoreTokens()) {
            int partialSum = 0;
            StringTokenizer plus = new StringTokenizer(minus.nextToken(), "+");

            while (plus.hasMoreTokens()) {
                partialSum += Integer.parseInt(plus.nextToken());                
            }

            if (result == Integer.MAX_VALUE) result = partialSum;
            else result -= partialSum;
        }

        System.out.println(result);
    }
}