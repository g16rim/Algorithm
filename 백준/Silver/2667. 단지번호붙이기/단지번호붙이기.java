import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static int n, dr[] = {-1, 1, 0, 0}, dc[] = {0, 0, -1, 1};
    private static char map[][];
    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '1') bfs(i, j);
            }
        }
        
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (int i = 0; i < result.size(); i++) sb.append(result.get(i)).append("\n");
        System.out.print(sb);
    }

    private static void bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        map[r][c] = 0;
        q.add(new int[] {r, c});
        int cnt = 1;

        while (!q.isEmpty()) {
            int temp[] = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = temp[0] + dr[i];
                int nc = temp[1] + dc[i];

                if (inRange(nr, nc)) {
                    map[nr][nc] = 0;
                    q.add(new int[] {nr, nc});
                    cnt++;
                }
            }
        }

        result.add(cnt);
    }

    private static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < n && map[r][c] == '1';
    }
}