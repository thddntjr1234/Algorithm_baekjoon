import java.util.*;
import java.io.*;

public class Main {
    static int N, M, V;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] visit;

    // 그래프 입력 메소드
    // 각 간선은 양방향으로 주어지므로 x-y, y-x에 대해 저장해야 한다
    static void put(int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }
    
    // dfs는 depth를 증가시키면서 탐색하는 구조이므로 정점에 연결된 방문하지 않은 정점 중 값이 낮은 정점을 탐색하도록 재귀로 구현
    static void dfs(int v) {
        visit[v] = true;

        sb.append(v).append(' ');
        for (int i: graph.get(v)) {
            if (visit[i] == false) {
                dfs(i);
            }
        }
    }

    // bfs는 dfs와는 달리 재귀나 스택으로 구현할 수 없다
    // 큐를 사용해서 연결된 간선까지의 정점들을 방문하고 큐에 저장한 뒤 처음 방문했던 정점을 기준으로(오름차순) 다시 방문하는 방식
    static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(v);
        visit[v] = true;

        while (!queue.isEmpty()) { // 
            int num = queue.poll();
            sb.append(num).append(' ');

            for (int i: graph.get(num)) {
                if (visit[i] == false) {
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        
        visit = new boolean[N+1];

        // 그래프 초기 생성(0~N)
        for (int i=0; i<N+1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 그래프 입력
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            put(x, y);
        }

        // dfs, bfs 모두 낮은 값을 가진 정점을 대상으로 탐색을 해야 하기 때문에 for문으로 정렬을 수행
        // 람다로도 구현 가능
        for (int i=1; i<=N; i++) {
            graph.get(i).sort(Comparator.naturalOrder());
        }

        dfs(V);
        sb.append('\n');
        Arrays.fill(visit, false); // visit 초기화

        bfs(V);
        System.out.println(sb);
    }
}