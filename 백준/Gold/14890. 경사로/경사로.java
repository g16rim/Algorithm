import java.io.*;
import java.util.*;

class Main {
    static int n, l, a[][], result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            check(i, 0); // row
//            System.out.println(i + " " + result);
            check(i, 1); // column
//            System.out.println(i + " " + result);
        }

        System.out.println(result);
    }

    static void check(int m, int flag) {
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            int diff;
            if (flag == 0) {
                diff = a[m][i] - a[m][i - 1];
            } else {
                diff = a[i][m] - a[i - 1][m];
            }

            if (diff == 0) {
                cnt++;
            } else if (diff == 1 && cnt >= l) { // 높아지면
                cnt = 1;
            } else if (diff == -1 && cnt >= 0) { // 낮아지면
                cnt = -l + 1;
            } else {
                return;
            }
        }
        if (cnt >= 0)
            result++;
    }
}