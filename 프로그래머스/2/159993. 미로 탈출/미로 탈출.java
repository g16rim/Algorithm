import java.util.*;

class Solution {
    private int sr, sc, lr, lc, er, ec, n, m;
    private boolean[][] visited;
    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'S') {
                    sr = i;
                    sc = j;
                } else if (maps[i].charAt(j) == 'L') {
                    lr = i;
                    lc = j;
                } else if (maps[i].charAt(j) == 'E') {
                    er = i;
                    ec = j;
                }
            }
        }
        visited = new boolean[n][m];
        int toLever = bfs(maps, sr, sc, lr, lc); // 레버 찾기
        if (toLever == -1) return -1;
        
        visited = new boolean[n][m];
        int toExit = bfs(maps, lr, lc, er, ec);
        if (toExit == -1) return - 1;
        
        return toLever + toExit;
    }
    
    private int bfs(String[] maps, int a, int b, int c, int d) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {a, b, 0});
        visited[a][b] = true;
        
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = temp[0] + dr[i];
                int nc = temp[1] + dc[i];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc] == true || maps[nr].charAt(nc) == 'X') continue;
                
                if (nr == c && nc == d) {
                    return temp[2] + 1;
                }
                
                q.add(new int[] {nr, nc, temp[2] + 1});
                visited[nr][nc] = true;
            }
        }
        
        return -1;
    }
}