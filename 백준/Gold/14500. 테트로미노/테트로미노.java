import java.io.*;
import java.util.*;

public class Main {
    static int n, m, paper[][], result;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        paper = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, paper[i][j]);
                visited[i][j] = false;
            }
        }
        
        System.out.println(result);
    }
    
    static void dfs(int r, int c, int cnt, int sum) {
        if (cnt == 4) {
            result = Math.max(result, sum);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc]) continue;
            
            if (cnt == 2) {
                visited[nr][nc] = true;
                dfs(r, c, cnt + 1, sum + paper[nr][nc]);
                visited[nr][nc] = false;
            }
                
            visited[nr][nc] = true;
            dfs(nr, nc, cnt + 1, sum + paper[nr][nc]);
            visited[nr][nc] = false;
        }
    }
}
