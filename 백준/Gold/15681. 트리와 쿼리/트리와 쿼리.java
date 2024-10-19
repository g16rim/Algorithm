import java.io.*;
import java.util.*;

public class Main {
    private static int n, r, q;
    private static List<Integer>[] graph;
    private static int[] dp;
    private static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[n + 1];
        dp = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        
        for (int i = 0; i < n - 1 ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        dfs(r);
        
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            int i = Integer.parseInt(br.readLine());
            sb.append(dp[i]).append("\n");
        }
        System.out.print(sb);
    }
    
    private static int dfs(int node) {
        visited[node] = true;
        dp[node] = 1;
        
        for (int child : graph[node]) {
            if (visited[child]) continue;
            dp[node] += dfs(child);
        }
        return dp[node];
    }
}
