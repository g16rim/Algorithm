import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static List<Node>[] graph;
	static StringBuilder sb = new StringBuilder();

	static class Node {
		int to;
		int weight;
		
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) graph[i] = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[from].add(new Node(to, weight));
		}
		
		dijkstra(V, start);
		
		System.out.println(sb);
	}

	
	static void dijkstra(int V, int start) {
		boolean[] visited = new boolean[V + 1];
		int[] minDistance = new int[V + 1];
		
		Arrays.fill(minDistance, Integer.MAX_VALUE);
		minDistance[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>
        ((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		pq.add(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			int temp = pq.poll().to;
			
			if (visited[temp]) continue;
			visited[temp] = true;
			
			for (Node next : graph[temp]) {
				if (minDistance[next.to] > minDistance[temp] + next.weight) {
					minDistance[next.to] = minDistance[temp] + next.weight;
					pq.add(new Node(next.to, minDistance[next.to]));					
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if (minDistance[i] == Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(minDistance[i]).append("\n");
		}
	}
}