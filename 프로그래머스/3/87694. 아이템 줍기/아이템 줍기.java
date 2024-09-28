import java.util.*;

class Solution {
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];
        for (int[] r : rectangle) {
            line(2 * r[0], 2 * r[1], 2 * r[2], 2 * r[3]);
        }
        bfs(2 * characterX, 2 * characterY, 2 * itemX, 2 * itemY);
        return answer;
    }
    
    public void line(int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i ++) {
            for (int j = y1; j <= y2; j++) {
                if (map[i][j] == -1) continue;
            
                if (i == x1 || i == x2 || j == y1 || j == y2) {
                    map[i][j] = 1; // 테두리인 경우 1로 표현
                } else {
                    map[i][j] = -1; // 테두리 내부 
                }
            }
        }
    }
    
    public void bfs(int startX, int startY, int itemX, int itemY) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {startX, startY, 1});
        
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                if (nx == itemX && ny == itemY) {
                    answer = Math.min(answer, temp[2] / 2);
                    return;
                }
                
                if (nx < 0 || ny < 0 || nx > 100 || ny > 100) continue;
                
                if (map[nx][ny] == 1) {
                    q.add(new int[] {nx, ny, temp[2] + 1});
                    map[nx][ny] = 0;
                }
            }
        }
    }
}