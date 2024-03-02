import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static boolean[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        map = new boolean[N][N * 2];
        star(0, N - 1, N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N * 2; j++)
                if (map[i][j]) sb.append("*");
                else sb.append(" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void star(int row, int col, int size) {
        if (size == 3) {
            map[row][col] = map[row + 1][col - 1] = map[row + 1][col + 1] = true;
            for (int c = col - 2; c < col + 3; c++) map[row + 2][c] = true;
            return;
        }

        int newSize = size / 2;
        star(row, col, newSize);
        star(row + newSize, col - newSize, newSize);
        star(row + newSize, col + newSize, newSize);
    }
}