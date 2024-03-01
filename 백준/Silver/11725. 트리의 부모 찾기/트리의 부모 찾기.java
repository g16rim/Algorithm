import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, visited[];
    private static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        visited = new int[N + 1];
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        visited[1] = -1;
        dfs(1);
        for (int i = 2; i <= N; i++) sb.append(visited[i]).append("\n");
        System.out.print(sb);
    }

    private static void dfs(int n) {
        for (int i = 0; i < graph[n].size(); i++) {
            int node = graph[n].get(i);
            if (visited[node] != 0) continue;
            visited[node] = n;
            dfs(node);
        }
    }
}