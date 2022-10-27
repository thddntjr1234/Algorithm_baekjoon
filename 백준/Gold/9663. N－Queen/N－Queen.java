import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int N;
    static int count = 0;
    
    public static boolean checkLocateQueen(int col) {
        /*
         * checkLocateQueen은 특정 depth에서 퀸을 놓을 수 있는지 검사하는 메소드이다
         * 이 메소드를 호출하기 전 전역 배열 arr에 해당 자리에 퀸을 놓고 메소드를 호출하면
         * 처음부터 바로 직전까지 놓은 퀸의 위치까지 반복하면서 첫 번째 if에서는
         * value(열)가 같은지를 검사하여 상하에 퀸이 존재하는지를 검사하고
         * else if에서는 검사할 위치와 놓은 퀸들의 위치가 대각선상에 놓여있는지를 검사하는데
         * 이 때 행의 차이(col-i)와 열의 차이(arr[col]-arr[i])가 동일하면 대각선 상에 있는 것이라고 판별한다.
         * 이 두 조건문을 모두 false로 넘기게 된다면 퀸을 놓을 수 있으므로 true를 반환하고 종료한다.
         */
        for(int i=0; i<col; i++) {
            if(arr[col] == arr[i]) return false;
            else if(Math.abs(arr[col] - arr[i]) == Math.abs(col - i)) return false;
        }

        return true;
    }

    public static void dfs(int depth) { 
        if (depth == N) { // 0~N-1까지 재귀하므로 N-1에서 재귀호출한 상태는 depth가 N이랑 같아짐
            count++; // 퀸을 전부 놓은 것이므로 count 증가
            return;
        }

        // 각 행마다 퀸을 놓을 수 있는지 검사하여 놓을 수 있으면 재귀하는 것을 N번 반복
        // 여기서 퀸을 놓을 수 없으면 해당 분기 이하의 조건들을 검사할 필요가 없으니 재귀하지 않음
        for (int i=0; i<N; i++) { 
            arr[depth] = i; // 먼저 퀸을 놓아야 checkLocateQueen에서 이를 사용할 수 있다.

            if (checkLocateQueen(depth)) {
                dfs(depth+1);
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        dfs(0);
        System.out.println(count);
    }
}