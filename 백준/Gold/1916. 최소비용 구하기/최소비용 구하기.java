import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<Node>[] graph;

    public static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, weight));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(V, start, end));
    }


    public static int dijkstra(int V, int start, int end) {
        boolean[] visited = new boolean[V + 1];
        int[] dist = new int[V + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<Node>
                ((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            int temp = pq.poll().to;

            if (visited[temp]) continue;
            visited[temp] = true;

            for (Node next : graph[temp]) {
                if (dist[next.to] > dist[temp] + next.weight) {
                    dist[next.to] = dist[temp] + next.weight;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
        return dist[end];
    }
}