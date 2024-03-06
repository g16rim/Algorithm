import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    private static int n, m;
    private static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    private static String map[];
    private static boolean visited[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new String[n];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) map[i] = br.readLine();

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0, 1});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = temp[0] + dr[i];
                int nc = temp[1] + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m && map[nr].charAt(nc) == '1' && visited[nr][nc] == false) {
                    if (nr == n - 1 && nc == m - 1) return temp[2] + 1;

                    q.add(new int[] {nr, nc, temp[2] + 1});
                    visited[nr][nc] = true;
                }
            }
        }
        return - 1;
    }
}