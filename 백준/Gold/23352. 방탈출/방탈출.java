import java.io.*;
import java.util.*;

public class Main {
    static int n, m, map[][], result, length, start;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    bfs(i, j);
                    clearVisited();
                }
            }
        }
        
        System.out.println(result);
    }
    
    static void bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        visited[r][c] = true;
        start = map[r][c];
        q.add(new int[] {r, c, 1});
        
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            
            if (temp[2] > length) {
                result = start + map[temp[0]][temp[1]];
                length = temp[2];
            } else if (temp[2] == length) {
                result = Math.max(result, start + map[temp[0]][temp[1]]);
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = dr[i] + temp[0];
                int nc = dc[i] + temp[1];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= m || map[nr][nc] == 0 || visited[nr][nc] == true) continue;
                visited[nr][nc] = true;
                
                q.add(new int[] {nr, nc, temp[2] + 1});                
            }
        }
    }
    
    static void clearVisited() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = false;
            }
        }
    }
}
