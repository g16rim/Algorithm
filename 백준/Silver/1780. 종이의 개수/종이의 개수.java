import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static int n, paper[][], result[] = new int[3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dnq(0, 0, n);
        for (int i = 0; i < 3; i++) System.out.println(result[i]);
    }

    private static void dnq(int x, int y, int size) {
        int s = paper[x][y];
        if (size == 1) {
            if (s == -1) result[0]++;
            else if (s == 0) result[1]++;
            else result[2]++;
            return;
        }

        for (int r = x; r < x + size; r++) {
            for (int c = y; c < y + size; c++) {
                if (paper[r][c] != s) {
                    dnq(x, y, size / 3);
                    dnq(x, y + size / 3, size / 3);
                    dnq(x, y + size / 3 * 2, size / 3);
                    dnq(x + size / 3, y, size / 3);
                    dnq(x + size / 3, y + size / 3, size / 3);
                    dnq(x + size / 3, y + size / 3 * 2, size / 3);
                    dnq(x + size / 3 * 2, y, size / 3);
                    dnq(x + size / 3 * 2, y + size / 3, size / 3);
                    dnq(x + size / 3 * 2, y + size / 3 * 2, size / 3);
                    return;
                }
            }
        }

        if (s == -1) result[0]++;
        else if (s == 0) result[1]++;
        else result[2]++;
    }
}