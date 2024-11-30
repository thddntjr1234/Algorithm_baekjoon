import java.util.*;
import java.io.*;

class Main {

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

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] board = new int[m][n];
        int[][] dist = new int[m][n];

        int[] dx = {0, 0, -1 , 1};
        int[] dy = {1, -1, 0, 0};

        Queue<Pair> queue = new LinkedList<>();

        /**
         * 익은 토마토를 큐에 먼저 저장한 뒤 bfs를 시작한다.
         * 이를 위해서 익지 않은 토마토들만 거리 배열을 -1로 선언하고
         * 탐색 가능 여부를 검사할 때 dist 배열의 값이 0 이상인 경우 익은 토마토 혹은 토마토가 없는 경우로 볼 수 있으니 반복문을 생략한다.
        */
        for (int x = 0; x < m; x++) {
            String[] line = br.readLine().split(" ");
            for (int y = 0; y < n; y++) {
                int num = Integer.parseInt(line[y]);
                board[x][y] = num;
                if (num == 1) {
                    queue.offer(new Pair(x, y));
                } else if (num == 0) {
                    dist[x][y] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (dist[nx][ny] >= 0) continue;

                queue.offer(new Pair(nx, ny));
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
            }
        }

        int result = 0;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (dist[x][y] == -1) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, dist[x][y]);
            }
        }

        System.out.println(result);
    }
}
