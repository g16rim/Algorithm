import java.util.*;

class Solution {
    int n, m;
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    q.add(new int[] {i, j, 0});
                    visited[i][j] = true;
                } 
            }
        }
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int cnt = cur[2];
            
            if (board[r].charAt(c) == 'G') return cnt;
            
            for (int[] d : dir) {
                int tr = r;
                int tc = c;
                
                while (true) {
                    int nr = tr + d[0];
                    int nc = tc + d[1];
                    
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m || board[nr].charAt(nc) == 'D') break;
                    
                    tr = nr;
                    tc = nc;
                }
                
                if (!visited[tr][tc]) {
                    visited[tr][tc] = true;
                    q.add(new int[] {tr, tc, cnt + 1});
                }
            }
        }
        
        return -1;
    }
}