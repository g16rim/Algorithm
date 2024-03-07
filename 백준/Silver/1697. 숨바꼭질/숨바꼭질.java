import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    private static int n, k;
    private static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int []> q = new ArrayDeque<>();
        visited[n] = true;
        q.add(new int[] {n, 0});

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int t = temp[0];
            if (t == k) return temp[1];

            if (isValid(t - 1)) {
                visited[t - 1] = true;
                q.add(new int[] {t - 1, temp[1] + 1});
            }
            if (isValid(t + 1)) {
                visited[t + 1] = true;
                q.add(new int[] {t + 1, temp[1] + 1});
            }
            if (isValid(2 * t)) {
                visited[2 * t] = true;
                q.add(new int[] {2 * t, temp[1] + 1});
            }
        }

        return -1;
    }

    private static boolean isValid(int n) {
        return n >= 0 && n <= 100000 && visited[n] == false;
    }
}