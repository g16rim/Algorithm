import java.io.*;
import java.util.*;

public class Main {
    private static int n, m, result = Integer.MAX_VALUE;
    private static String[] map;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static boolean[][] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new String[n];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine();
        }
        
        bfs();
        System.out.println(result);
    }
    
    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            
            if (temp[0] == n - 1 && temp[1] == m - 1) {
                result = temp[2];
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = temp[0] + dr[i];
                int nc = temp[1] + dc[i];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= m || map[nr].charAt(nc) == '0' || visited[nr][nc] == true) continue;
                
                q.add(new int[] {nr, nc, temp[2] + 1});
                visited[nr][nc] = true;
            }
        }
    }
}
