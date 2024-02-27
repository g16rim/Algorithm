import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int vertex, weight;
		Node next;

		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());

		Node[] adjList = new Node[V + 1];
		int[] minDistance = new int[V + 1];
		boolean[] visited = new boolean[V + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]);
		}

		Arrays.fill(minDistance, Integer.MAX_VALUE);
		minDistance[start] = 0;

		int min = 0, stopOver = 0;
		for (int i = 1; i <= V; i++) { // 모든 정점이 다 처리될 때까지 반복
			// step1 : 미방문 정점 중 출발지에서 가장 가까운 정점 선택
			min = Integer.MAX_VALUE;
			stopOver = -1;

			for (int j = 1; j <= V; j++) {
				if (!visited[j] && min > minDistance[j]) {
					min = minDistance[j];
					stopOver = j;
				}
			}

			if (stopOver == -1)
				break;
			visited[stopOver] = true;

			// step2 : 미방문 정점들에 대해 선택된 경유지를 거쳐서 가는 비용과 기존 최소 비용을 비교해서 업데이트
			for (Node temp = adjList[stopOver]; temp != null; temp = temp.next) {
				if (minDistance[temp.vertex] > min + temp.weight) {
					minDistance[temp.vertex] = min + temp.weight;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (minDistance[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(minDistance[i]).append("\n");
			}
		}
		System.out.print(sb);
	}
}