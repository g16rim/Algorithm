import java.io.*;
import java.util.*;

public class Main {
    private static int n, m, str, stc;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    
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
                if (map[i][j] == 2) {
                    str = i;
                    stc = j;
                }
            }
        }
        
        bfs();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    sb.append("-1 ");
                } else {
                    sb.append(map[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    
    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {str, stc, 0});
        map[str][stc] = 0;
        visited[str][stc] = true;
        
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = temp[0] + dr[i];
                int nc = temp[1] + dc[i];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc] == true || map[nr][nc] == 0) continue;
                
                map[nr][nc] = temp[2] + 1;
                visited[nr][nc] = true;
                q.add(new int[] {nr, nc, map[nr][nc]});
            }
        }
    }
}
