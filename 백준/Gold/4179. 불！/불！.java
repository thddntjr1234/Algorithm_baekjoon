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
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        String[][] board = new String[1001][1001];
        int[][] dist1 = new int[1001][1001];
        int[][] dist2 = new int[1001][1001];

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        Queue<Pair> q1 = new LinkedList<>();
        Queue<Pair> q2 = new LinkedList<>();

        for (int x = 0; x < r; x++) {
            for (int y = 0; y < c; y++) {
                dist1[x][y] = -1;
                dist2[x][y] = -1;
            }
        }

        // 불과 지훈의 시작 위치를 각 큐에 추가한다.
        for (int x = 0; x < r; x++) {
            String[] line = br.readLine().split("");
            for (int y = 0; y < c; y++) {
                board[x][y] = line[y];
                // 불인 경우 q1에 추가
                if (line[y].equals("F")) {
                    q1.offer(new Pair(x, y));
                    dist1[x][y] = 0;
                }
                // 지훈인 경우 q2에 추가
                if (line[y].equals("J")) {
                    q2.offer(new Pair(x, y));
                    dist2[x][y] = 0;
                }
            }
        }

        // 지훈의 bfs를 수행할 때 불의 도착 여부를 알기 위해 불에 대해 먼저 bfs를 수행한다.
        while (!q1.isEmpty()) {
            Pair cur = q1.remove();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                // 불의 경우는 테두리를 초과하는 경우 기존 bfs처럼 continue
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (dist1[nx][ny] >= 0 || board[nx][ny].equals("#")) continue;
                
                dist1[nx][ny] = dist1[cur.x][cur.y] + 1;
                q1.offer(new Pair(nx, ny));
            } 
        }

        while (!q2.isEmpty()) {
            Pair cur = q2.remove();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                // 벽을 넘는 경우는 탈출에 성공한 케이스로, 현재 위치에서 +1한 값을 반환하고 종료
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    System.out.println(dist2[cur.x][cur.y] + 1);
                    return;
                }

                // 이미 bfs를 수행했거나, 벽인 경우를 검증
                if (dist2[nx][ny] >= 0 || board[nx][ny].equals("#")) continue;
                // 불이 지훈보다 빨리 도착하거나, 같은 시간에 도착하는 경우를 검증
                // dist1이 -1이 아닌 것을 검증하는 이유는 뒤의 조건식에서 -1인 경우 참인 경우로 보기 때문
                if (dist1[nx][ny] != -1 && dist1[nx][ny] <= dist2[cur.x][cur.y] + 1) continue;

                dist2[nx][ny] = dist2[cur.x][cur.y] + 1;
                q2.offer(new Pair(nx, ny));
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
