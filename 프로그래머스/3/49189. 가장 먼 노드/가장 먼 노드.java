import java.util.*;

class Solution {
    List<Integer>[] graph;
    boolean[] visited;
    int[] dist;
    int maxValue = 0;
    
    public int solution(int n, int[][] edge) {
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {1, 0});
        visited[1] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            maxValue = Math.max(maxValue, cur[1]);
            dist[cur[0]] = cur[1];
            
            for (int next : graph[cur[0]]) {
                if (!visited[next]) {
                    q.add(new int[] {next, cur[1] + 1});
                    visited[next] = true;
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == maxValue) answer++;
        }         
        return answer;
    }
}