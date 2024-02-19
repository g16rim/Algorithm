import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, V;
    static int[][] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V);
        System.out.print(sb);
    }

    static void dfs(int V) {
        visited[V] = true;
        sb.append(V).append(" ");
        for (int i = 1; i < N + 1; i++) {
            if (graph[V][i] == 1 && visited[i] == false) {
                dfs(i);
            }
        }
    }

    static void bfs(int V) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(V);
        visited[V] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            sb.append(node).append(" ");
            for (int i = 1; i < N + 1; i++) {
                if (graph[node][i] == 1 && visited[i] == false) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}