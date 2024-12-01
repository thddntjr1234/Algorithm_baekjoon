import java.util.*;
import java.io.*;

class Main {

    static class Pair {
        public int x;
        public int y;
        public int z;

        public Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int h = Integer.parseInt(input[2]);

        int[][][] board = new int[h][m][n];
        int[][][] dist = new int[h][m][n];

        int[] dx = {0, 0, -1 , 1, 0, 0};
        int[] dy = {1, -1, 0, 0, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        Queue<Pair> queue = new LinkedList<>();

        /**
         * 3차원 토마토 문제의 경우 z축이 추가되므로 z축에 대한 반복문을 추가한다.
         * 익은 토마토를 큐에 먼저 저장한 뒤 bfs를 시작한다.
         * 이를 위해서 익지 않은 토마토들만 거리 배열을 -1로 선언하고
         * 탐색 가능 여부를 검사할 때 dist 배열의 값이 0 이상인 경우 익은 토마토 혹은 토마토가 없는 경우로 볼 수 있으니 반복문을 생략한다.
        */
        for (int z = 0; z < h; z++) {
            for (int x = 0; x < m; x++) {
                String[] line = br.readLine().split(" ");
                for (int y = 0; y < n; y++) {
                    int num = Integer.parseInt(line[y]);
                    board[z][x][y] = num;
                    if (num == 1) {
                        queue.offer(new Pair(x, y, z));
                    } else if (num == 0) {
                        dist[z][x][y] = -1;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            for (int i = 0; i < 6; i++) {       
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nz = cur.z + dz[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || nz < 0 || nz >= h) continue;
                if (dist[nz][nx][ny] >= 0) continue;

                queue.offer(new Pair(nx, ny, nz));
                dist[nz][nx][ny] = dist[cur.z][cur.x][cur.y] + 1;
            }
        }

        int result = 0;
        for (int z = 0; z < h; z++) {
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (dist[z][x][y] == -1) {
                        System.out.println(-1);
                        return;
                    }
                    result = Math.max(result, dist[z][x][y]);
                }
            }
        }
        System.out.println(result);
    }
}
