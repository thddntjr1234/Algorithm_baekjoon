import java.util.*;
import java.io.*;

public class Main {
    static long C;

    // 수학 문제 어렵다...
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A= Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A, B));
    }

    static long pow(long A, long B) {
        if (B == 1) return A % C;

        long result = pow(A, B/2);

        if (B % 2 == 1) {
            return ((result * result % C) * A) % C;
        }

        return result * result % C;
    }
}