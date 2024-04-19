import java.io.*;
import java.util.*;

public class Main {
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
        Deque<int[]> q = new ArrayDeque<>();
        visited[n] = true;
        q.addLast(new int[] {n, 0});

        while (!q.isEmpty()) {
            int[] temp = q.pollFirst();
            int t = temp[0];

            if (t == k) {
                return temp[1];
            }

            if (isPossible(2 * t)) {
                visited[2 * t] = true;
                q.addFirst(new int[]{2 * t, temp[1]});
            }
            if (isPossible(t - 1)) {
                visited[t - 1] = true;
                q.addLast(new int[]{t - 1, temp[1] + 1});
            }
            if (isPossible(t + 1)) {
                visited[t + 1] = true;
                q.addLast(new int[]{t + 1, temp[1] + 1});
            }
        }
        return -1;
    }

    private static boolean isPossible(int t) {
        return t >= 0 && t <= 100000 && visited[t] == false;
    }
}