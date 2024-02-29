import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] originCell;
    static List<Core> cores = new ArrayList<>();
    static int[] coresDir;
    static int[] result;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static final int LINE = -1;

    static class Core {
        int x, y;

        public Core(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            originCell = new int[N][N];
            result = new int[2];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    originCell[i][j] = Integer.parseInt(st.nextToken());
                    if (originCell[i][j] == 1 && (i != 0 && j != 0 && i != N - 1 && j != N - 1)) {
                        cores.add(new Core(i, j));
                    }
                }
            }

            coresDir = new int[cores.size()];
            setCoresDir(0, 0);
            sb.append("#").append(tc).append(" ").append(result[1]).append("\n");
            cores.clear();
        }
        System.out.print(sb);
    }

    private static boolean makeLine(int i, int dir) {
        // i번째 core, dir = coresDir[i]
        int x = cores.get(i).x;
        int y = cores.get(i).y;
        List<Core> history = new ArrayList<>();
        boolean canMake = false;
        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                canMake = true;
                break;
            }
            if (originCell[nx][ny] != 0) {
                break;
            }
            originCell[nx][ny] = LINE;
            history.add(new Core(nx, ny));
            x = nx;
            y = ny;
        }
        if (canMake == false) {
            for (int j = 0; j < history.size(); j++) {
                originCell[history.get(j).x][history.get(j).y] = 0;
            }
        }

        return canMake;
    }

    private static void eraseLine(int i, int dir) {
        int x = cores.get(i).x;
        int y = cores.get(i).y;

        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;
            if (originCell[nx][ny] == LINE) originCell[nx][ny] = 0;
            x = nx;
            y = ny;
        }
    }

    private static int compareOne() {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (originCell[i][j] == LINE) {
                    result++;
                }
            }
        }
        return result;
    }

    // 방향을 고른다
    // 모든 core의 방향을 선택
    // 다 골라지면 임시셀을 만들고(복구용)
    // O(4^12 * N^2)
    private static void setCoresDir(int idx, int coreCnt) {
    	if (coreCnt + (cores.size() - idx) < result[0]) return;
    	
        if (idx == cores.size()) {
            if (coreCnt > result[0]) {
                result[0] = coreCnt;
                result[1] = compareOne();
            } else if (coreCnt == result[0]) {
                result[1] = Math.min(result[1], compareOne());
            }
            return;
        }
        for (int dir = 0; dir < 4; dir++) {
            // 현재 core에서 dir 방향으로 뻗어 나갈거야
            int cnt = coreCnt;
            boolean canMake = makeLine(idx, dir);
            if (canMake) {
                cnt++;
            }
            setCoresDir(idx + 1, cnt);
            if (canMake) {
                // erase Line
                eraseLine(idx, dir);
            }
        }
    }
}