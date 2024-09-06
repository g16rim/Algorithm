import java.io.*;
import java.util.*;

public class Main {
    static int[] opposite = {5, 3, 4, 1, 2, 0};
    static int[][] dice;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dice = new int[n][6];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        for (int bottomIndex = 0; bottomIndex < 6; bottomIndex++) { // 인덱스
            int bottom = bottomIndex;
            int sum = 0;
            int top = opposite[bottom]; // 인덱스

            sum += getMaxSide(0, bottom, top);

            for (int i = 1; i < n; i++) {
                int bottomValue = dice[i - 1][top]; // 값
                bottom = findIndex(i, bottomValue); // 인덱스
                top = opposite[bottom]; // 인덱스

                sum += getMaxSide(i, bottom, top);
            }

            result = Math.max(result, sum);
        }

        System.out.println(result);
    }

    static int getMaxSide(int row, int bottom, int top) {
        int max = 0;
        for (int i = 0; i < 6; i++) {
            if (i == bottom || i == top) continue;
            max = Math.max(max, dice[row][i]);
        }
        return max;
    }

    static int findIndex(int row, int value) {
        for (int i = 0; i < 6; i++) {
            if (dice[row][i] == value) {
                return i;
            }
        }
        return -1;
    }
}