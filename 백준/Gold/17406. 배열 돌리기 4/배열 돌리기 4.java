import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n, m, k, arr[][], copy[][], op[][], result = Integer.MAX_VALUE, p[];
    private static boolean visited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][m + 1];
        op = new int[k][3];
        visited = new boolean[k];
        p = new int[k];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                op[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 연산 순서
        perm(0);
        System.out.println(result);
    }

    private static void rotate(int r, int c, int s) {
        if (s == 0) {
//            System.out.println(Arrays.deepToString(arr));
            return;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int j = c - s; j <= c + s; j++) q.add(copy[r - s][j]); // →
        q.pollLast();
        for (int i = r - s; i <= r + s; i++) q.add(copy[i][c + s]); // ↓
        q.pollLast();
        for (int j = c + s; j >= c - s; j--) q.add(copy[r + s][j]); // ←
        q.pollLast();
        for (int i = r + s; i >= r - s; i--) q.add(copy[i][c - s]); // ↑
        q.pollLast();

        q.addFirst(q.pollLast());

        for (int j = c - s; j <= c + s; j++) copy[r - s][j] = q.pollFirst();
        for (int i = r - s + 1; i <= r + s; i++) copy[i][c + s] = q.pollFirst();
        for (int j = c + s - 1; j >= c - s; j--) copy[r + s][j] = q.pollFirst();
        for (int i = r + s - 1; i > r - s; i--) copy[i][c - s] = q.pollFirst();

        rotate(r, c, s - 1);
    }

    private static void perm(int cnt) {
        if (cnt == k) {
//            System.out.println(Arrays.toString(p));

            // copy
            copy = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) copy[i] = Arrays.copyOf(arr[i], arr[i].length);
            // arr 순서대로 rotate
            for (int i = 0; i < k; i++) rotate(op[p[i]][0], op[p[i]][1], op[p[i]][2]);
            // findMin
            findMin();
            return;
        }

        for (int i = 0; i < k; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            p[cnt] = i;
            perm(cnt + 1);
            visited[i] = false;
        }
    }

    private static void findMin() {
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= m; j++) sum += copy[i][j];
//            System.out.println("sum " + sum);
            result = Math.min(result, sum);
        }
    }
}