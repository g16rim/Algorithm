import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    private static int n, result, map[][] = new int[101][101];
    private static boolean visited[][] = new boolean[101][101];
    private static int dr[] = {-1, 1, 0, 0}, dc[] = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        for (int h = 0; h < max; h++) {
            int temp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (inRange(i, j, h)) {
                        dfs(i, j, h);
                        temp++;
                    }
                }
            }
            result = Math.max(result, temp);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    visited[i][j] = false;
                }
            }
        }
        System.out.println(result);
    }

    private static void dfs(int r, int c, int h) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (inRange(nr, nc, h)) {
                dfs(nr, nc, h);
            }
        }
    }

    private static boolean inRange(int r, int c, int h) {
        return r >= 0 && c >= 0 && r < n && c < n && map[r][c] > h && !visited[r][c];
    }
}