import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result = Integer.MAX_VALUE;
    static int[][] originBoard, tempBoard;
    static List<int[]> cctv = new ArrayList<>();
    static int[] combArr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        originBoard = new int[N][M];
        tempBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                originBoard[i][j] = Integer.parseInt(st.nextToken());
                if (originBoard[i][j] >= 1 && originBoard[i][j] <= 5) {
                    cctv.add(new int[] {i, j, originBoard[i][j]});
                }
            }
        }
        combArr = new int[cctv.size()];
        comb(0);
        System.out.println(result);
    }

    static void comb(int cnt) {
        if (cnt == cctv.size()) {
            copyBoard();
            watch();
            return;
        }

        for (int i = 0; i < 4; i++) {
            combArr[cnt] = i;
            comb(cnt + 1);
        }
    }

    static void watch() {
        for (int i = 0; i < combArr.length; i++) {
            switch (cctv.get(i)[2]) { // cctv 종류
                case 1:
                    fun1(i);
                    continue;
                case 2:
                    fun2(i);
                    continue;
                case 3:
                    fun3(i);
                    continue;
                case 4:
                    fun4(i);
                    continue;
                case 5:
                    fun5(i);
            }
        }
        result = Math.min(result, countZero());
    }

    static void fun1(int i) {
        makeSharp(combArr[i], cctv.get(i)[0], cctv.get(i)[1]);
    }

    static void fun2(int i) {
        if (combArr[i] % 2 == 0) {
            makeSharp(combArr[i], cctv.get(i)[0], cctv.get(i)[1]);
            makeSharp(combArr[i] + 1, cctv.get(i)[0], cctv.get(i)[1]);
        } else {
            makeSharp(combArr[i] - 1, cctv.get(i)[0], cctv.get(i)[1]);
            makeSharp(combArr[i], cctv.get(i)[0], cctv.get(i)[1]);
        }
    }

    static void fun3(int i) {
        int[][] dir = {{0, 2}, {2, 1}, {1, 3}, {3, 0}};
        makeSharp(dir[combArr[i]][0], cctv.get(i)[0], cctv.get(i)[1]);
        makeSharp(dir[combArr[i]][1], cctv.get(i)[0], cctv.get(i)[1]);
    }

    static void fun4(int i) {
        for (int n = 0; n < 4; n++) {
            if (n == combArr[i]) continue;
            makeSharp(n, cctv.get(i)[0], cctv.get(i)[1]);
        }
    }

    static void fun5(int i) {
        makeSharp(0, cctv.get(i)[0], cctv.get(i)[1]);
        makeSharp(1, cctv.get(i)[0], cctv.get(i)[1]);
        makeSharp(2, cctv.get(i)[0], cctv.get(i)[1]);
        makeSharp(3, cctv.get(i)[0], cctv.get(i)[1]);
    }

    static int countZero() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempBoard[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    static void makeSharp(int dir, int x, int y) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if (nx < 0 || ny < 0 || nx >= N || ny >= M || tempBoard[nx][ny] == 6) return;
        tempBoard[nx][ny] = -1;
        makeSharp(dir, nx, ny);
    }

    static void copyBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempBoard[i][j] = originBoard[i][j];
            }
        }
    }
}