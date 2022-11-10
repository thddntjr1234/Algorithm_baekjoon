import java.io.*;
// https://st-lab.tistory.com/134 참고한 풀이
// 재귀 특성, dp를 사용하는 점화식을 잘 고민해야 할 것 같다.

public class Main {
    static int N, Mod = 1000000000;
    static Integer[][] dp;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new Integer[N+1][10];

        // 첫번쨰 자리는 끝 수이므로 경우의 수가 1로 고정됨
        // 재귀 특성상 탐색 종료시 반환값이 있어야 하므로 탐색이 종료되는 지점의 값을 1로 선언해 준다
        for (int i=0; i<10; i++) { 
            dp[1][i] = 1;
        }

        long sum = 0; // 9.99..억이 recursion이 반환하는 최대값이므로 3번만 더하더라도 오버플로가 발생할 수 있음, long타입으로 선언
        // N번째 자리를 1~9부터 시작하게 해서 계단수를 찾도록 재귀시킨다.
        // for문으로 1~9까지 돌리는 이유는 작성한 재귀 함수에선 N번째 자리 값 M에 대해서 하위 자리들을 탐색해 나가고 N번째 자리에 대해 탐색하지 않기 때문임
        // 때문에 main에서 for문으로 이 M값들을 돌려서 각 값에 대한 계단수 개수를 구하는 것
        for (int i=1; i<10; i++) {
            sum += recursion(N, i);
        }

        System.out.println(sum % Mod);
    }

    static int recursion(int index, int value) {
        if (index == 1) return dp[index][value]; // index가 1인 경우엔 최대로 탐색했으므로 밑의 조건식을 지나게 하지 않고 return한다

        if (dp[index][value] == null) { // 구하지 않은 값(아직 탐색하지 않은 수라면)
            if (value == 0) dp[index][value] = recursion(index-1, 1); // 0이라면 1차이가 나는 값은 1밖에 없음
            else if (value == 9) dp[index][value] = recursion(index-1, 8); // 9라면 1차이가 나는 값은 8밖에 없음
            else dp[index][value] = recursion(index-1, value-1) + recursion(index-1, value+1); // 이외는 +1, -1이 가능
        }

        return dp[index][value] % Mod; // 매 반환마다 10억으로 나눈 나머지 값을 반환해야 오버플로가 일어나지 않는다.
    }
}