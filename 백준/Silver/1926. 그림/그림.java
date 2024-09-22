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
        String[] size = br.readLine().split(" ");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);

        // 보드 초기화
        int[][] board = new int[n][m];
        // 방문 배열 초기화
        int[][] visited = new int[n][m];
        // dx, dy용 상하좌우 탐색용 배열 초기화
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        // 그림의 개수, 가장 넓은 그림의 넓이 변수 선언
        int num = 0;
        int mx = 0;
        // bfs를 위한 큐 선언
        Queue<Pair> queue = new LinkedList<>();
        
        // 입력받은 값을 board에 초기화
        for (int x=0; x<n; x++) {
            String[] input = br.readLine().split(" ");
            for (int y=0; y<m; y++) {
                board[x][y] = Integer.parseInt(input[y]);
            }
        }

        /**
         * 도화지에 그려진 모든 그림을 찾기 위해서 board 내의 모든 영역에 대해 bfs를 수행한다.
         * bfs를 수행 할 수 있는 조건은
         * 1. 그림이 그려진 곳
         * 2. 방문한 적이 없음을 만족해야 한다.
         */
        for (int x=0; x<n; x++) {
            for (int y=0; y<m; y++) {
                // 그림이 그려져 있지 않거나 이미 방문한 그림이면 스킵
                if (board[x][y] == 0 || visited[x][y] == 1) continue;
                // 그림 탐색을 시작하는 경우기 때문에 그림 갯수 증가, 방문 기록
                num++;
                visited[x][y] = 1;
                // 첫 탐색이므로 큐에 추가한다
                queue.add(new Pair(x, y));
                int area = 0;

                // 큐가 비어있지 않으면 아직 모든 탐색이 종료되지 않은 것
                while(!queue.isEmpty()) {
                    // 그림을 계속해서 찾기 때문에 넓이를 1씩 증가시킨다.
                    area++;

                    // 큐에 있는 좌표를 꺼내서 해당 좌표를 기준으로 상하좌우 탐색을 수행한다.
                    Pair cur = queue.remove();
                    for(int i=0; i<4; i++) {
                        int nx = cur.x + dx[i];
                        int ny = cur.y + dy[i];

                        // 상하좌우가 유효한 좌표인지 체크
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (board[nx][ny] == 0 || visited[nx][ny] == 1) continue;

                        // 유효한 좌표이면 방문 표시를 남기고 큐에 추가한다.
                        visited[nx][ny] = 1;
                        queue.add(new Pair(nx, ny));
                    }
                }

                // 하나의 그림 영역에 대한 탐색이 종료되면 해당 그림의 넓이를 비교
                mx = Math.max(mx, area);
            }
        }

        System.out.println(num);
        System.out.println(mx);
    }
}
