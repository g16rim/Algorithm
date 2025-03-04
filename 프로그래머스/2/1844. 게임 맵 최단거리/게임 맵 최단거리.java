import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == n - 1 && cur[1] == m - 1) {
                return cur[2];
            }
            
            for (int i = 0; i < dir.length; i++) {
                int nr = cur[0] + dir[i][0];
                int nc = cur[1] + dir[i][1];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc] || maps[nr][nc] == 0) continue;
                
                q.add(new int[] {nr, nc, cur[2] + 1});
                visited[nr][nc] = true;
            }
        }
        
        return -1;
    }
}