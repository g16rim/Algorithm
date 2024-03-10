import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static int m, n, k, map[][];
    private static int dr[] = {-1, 1, 0, 0}, dc[] = {0, 0, -1, 1};
    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[m][n];

        for (int i = 0; i < k; i++) {
            int sr = 0; int sc = 0;
            int er = 0; int ec = 0;
            st = new StringTokenizer(br.readLine());
            sc = Integer.parseInt(st.nextToken());
            sr = Integer.parseInt(st.nextToken());
            ec = Integer.parseInt(st.nextToken());
            er = Integer.parseInt(st.nextToken());

            for (int r = sr; r < er; r++) {
                for (int c = sc; c < ec; c++) {
                    map[r][c] = 1;
                }
            }
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (map[r][c] == 0) bfs(r, c);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) sb.append(result.get(i)).append(" ");
        System.out.println(sb);
    }

    private static void bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        map[r][c] = 1;
        q.add(new int[] {r, c, 1});

        int cnt = 1;

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = temp[0] + dr[i];
                int nc = temp[1] + dc[i];

                if (inRange(nr, nc)) {
                    map[nr][nc] = 1;
                    q.add(new int[]{nr, nc, temp[2] + 1});
                    cnt++;
                }
            }
        }
        result.add(cnt);
    }

    private static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < m && c < n && map[r][c] == 0;
    }
}