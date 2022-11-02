import java.io.*;
import java.util.*;

public class Main {
    static int[][][] dp;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[21][21][21]; // 0~20범위의 w(a,b,c)에 대한 결과는 공유할 수 있기 때문에 while에서 매번 초기화하지 않아도 됨

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            System.out.println(String.format("w(%d, %d, %d) = %d", a, b, c, w(a, b, c)));
        }
    }

    /*
     * 첫번째 풀이, dp를 사용한 메모이제이션으로 풀어야 할 수 w(a, b, c)에 대해 top-down 방식으로
     * 작은 문제들로 분해한다. 각 문제들은 이후 다시 계산하지 않고 dp배열에서 꺼내 사용하므로 재귀 횟수가 줄어든다.
     * 
     * 첫 번째 제출시 런타임 에러가 생겼는-데, if (dp[a][b][c] > 0) return dp[a][b][c]; 이 부분에 대해
     * -1 수가 접근시 배열 인덱스 범위 오류로 인한 것으로 먼저 배열 인덱스 오류가 일어나지 않게 -1인 경우를 탐색하도록 하고,
     * 해당 조건문의 return dp[a][b][c] = -1도 인덱스 참조 오류가 생기기 때문에 굳이 한번만 리턴하면 될 것을 dp에 담지 않고 바로 반환한다.
     * 두 번째 제출시 런타임 오류는 첫 번째로 입력받은 수에 대해 배열 크기를 지정하는데, 이 때 -1이상의 수가 입력되면 
     * java.lang.NegativeArraySizeException 오류가 발생함. 해법은 입력받은 정수에 대한 절대값+1으로 배열을 선언해주면 될 듯(공간복잡도 최소화)
     * 
     * 또 자꾸 배열 인덱스 참조오류가 발생하는데 해당 테케를 찾지 못하겠음
     * -> dp[a][b][c] > 0 을 else if에 넣지 않고 각 else if문의 하위 조건문으로 넣어서 해보기
     * -> 2 50 50일 때 w(20, 20, 20)으로 다시 선언해주면서 배열 크기가 재선언이 안된 것이 문제였던 듯 -> 재선언 하도록 수정
     * -> 메모리 초과 오류, a, b, c = 50일 때 50^3 = 125,000 * 4byte이므로 500MB라 초과하게 됨 -> a, b, c값 검사에 대해 먼저 적용을
     * 
     * --> 최종 정리, 배열 크기를 가변적으로 선언하지 말고 유효 범위만큼만 하기(50, 50, 50과 같은 경우에는 메모리 초과 발생)
     * 엣지케이스와 같은 테케와 조건문을 잘 확인해보기
     * 
     */
    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c<= 0) return 1; 

        else if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] = w(20, 20, 20);
        }

        else if (a < b && b < c) {
            if(dp[a][b][c] > 0) return dp[a][b][c];
            else return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        }

        else {
            if(dp[a][b][c] > 0) return dp[a][b][c];
            else return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        } 
    }
}