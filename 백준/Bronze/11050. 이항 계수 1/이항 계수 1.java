import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        System.out.println(factorial(N) / (factorial(N-K)*factorial(K)));

    }
    public static int factorial(int n) {
        int ans = 1;
        while(n>1) {
            ans *= n--;
        }
        return ans;
    }
}