import java.io.*;
import java.util.*;

public class Main {
    static int INF = 200_000_000;
    static int n, e, v1, v2, dist[], result1, result2;
    static List<Node>[] graph;
    
    public static class Node implements Comparable<Node> {
        int end, weight;
        
        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        dist = new int[n + 1];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        
        result1 += dijkstra(1, v1);
        result1 += dijkstra(v1, v2);
        result1 += dijkstra(v2, n);
        
        result2 += dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, n);
        
        System.out.println((result1 >= INF && result2 >= INF) ? -1 : Math.min(result1, result2));
    }
    
    static int dijkstra(int s, int e) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, INF);
        pq.add(new Node(s, 0));
        dist[s] = 0;
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (dist[cur.end] < cur.weight) continue;
            
            for (Node n : graph[cur.end]) {
                if (cur.weight + n.weight < dist[n.end]) {
                    dist[n.end] = cur.weight + n.weight;
                    pq.add(new Node(n.end, dist[n.end]));
                }
            }
        }
        
        return dist[e];
    }
}
