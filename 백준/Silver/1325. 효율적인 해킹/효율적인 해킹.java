import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static int N, M;
    private static int[] cnt = new int[10001];
    private static int[] visited = new int[10001];
    private static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        cnt = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) visited[j] = 0;
            bfs(i);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (max < cnt[i]) max = cnt[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (max == cnt[i]) sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    private static void bfs(int n) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[n] = 1;
        q.add(n);

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i : graph[x]) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    cnt[i]++;
                    q.add(i);
                }
            }
        }
    }

//    private static void dfs(int n) {
//        for (int i : graph[n]) {
//            if (!visited[i]) {
//                cnt[i]++;
//                visited[i] = true;
//                dfs(i);
//            }
//        }
//    }
}