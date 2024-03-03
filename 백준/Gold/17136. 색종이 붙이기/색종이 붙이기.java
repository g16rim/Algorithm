import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int map[][], paper[] = {0, 5, 5, 5, 5, 5}, result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[10][10];
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

//        System.out.println(Arrays.toString(paper));
        backtrack(0, 0, 0);
        if (result == Integer.MAX_VALUE) result = -1;
        System.out.println(result);
    }

    private static void backtrack(int r, int c, int cnt) {
        if (cnt > result) return;
//        System.out.println("[" + r + " " + c + " " + cnt + "]");
        if (c >= 10) {
            backtrack(r + 1, 0, cnt); // 다음 행
            return;
        }

        if (r >= 10) {
            result = Math.min(result, cnt);
//            System.out.println(Arrays.toString(paper));
            return;
        }

        if (map[r][c] == 0) {
            backtrack(r, c + 1, cnt);
            return;
        }

        for (int i = 5; i > 0; i--) {
            if (paper[i] > 0 && isPossible(r, c, i)) {
                paper[i]--;
//                System.out.println(Arrays.toString(paper));
                setPaper(r, c, i, 0); // 색종이 덮기
                backtrack(r, c + i, cnt + 1);
                setPaper(r, c, i, 1); // 다시 되돌리기
                paper[i]++;
            }
        }
    }

    private static void setPaper(int r, int c, int size, int flag) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[r + i][c + j] = flag;
            }
        }
    }

    private static boolean isPossible(int r, int c, int size) {
        if (r + size > 10 || c + size > 10) return false; // 범위 밖
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[r + i][c + j] == 0) return false;
            }
        }
        return true;
    }
}