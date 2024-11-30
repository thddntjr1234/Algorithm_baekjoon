import java.util.*;
import java.io.*;

public class Main {
    static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);

        // 보드 초기화
        int[][] board = new int[n][m];
        // 거리 배열 초기화
        int[][] distance = new int[n][m];
        // dx, dy용 상하좌우 배열 초기화
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        // 입력받은 값을 board에 초기화, distance -1로 설정
        for (int x=0; x<n; x++) {
            String[] input = br.readLine().split("");
            for (int y=0; y<m; y++) {
                board[x][y] = Integer.parseInt(input[y]);
                distance[x][y] = -1;
            }
        }

        Queue<Pair> queue = new LinkedList<>();

        distance[0][0] = 0;
        queue.add(new Pair(0, 0));

        while(!queue.isEmpty()) {
            Pair cur = queue.remove();
            for (int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == 0 || distance[nx][ny] >= 0) continue;

                distance[nx][ny] = distance[cur.x][cur.y] + 1;
                queue.add(new Pair(nx, ny));
            }
        }

        System.out.println(distance[n-1][m-1] + 1);
    }
}
