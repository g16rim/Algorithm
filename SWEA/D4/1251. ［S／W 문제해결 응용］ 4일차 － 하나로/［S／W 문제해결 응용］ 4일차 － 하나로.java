import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[] x, y, parents;
	static Edge[] edgeList;
	static int N, result;
	static double E;
	
	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		double weight;
		
		public Edge(int start, int end, double weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}		
		
		@Override
		public String toString() {
			return start + " " + end + " " + weight + "\n";
		}
	}
	
	static void make() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			x = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			y = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());
			
			parents = new int[N];
			edgeList = new Edge[N * (N - 1) / 2];
			
			int idx = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					edgeList[idx++] = new Edge(i, j, (Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2)));
				}
			} // 간선 저장
		
			make();
			Arrays.sort(edgeList);
			
			double result = 0;
			int count = 0;
			for (Edge edge : edgeList) {
				if (union(edge.start, edge.end)) {
					result += edge.weight;
					if (++count == N - 1) {
						break;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(Math.round(E * result)).append("\n");
		}
		System.out.println(sb);
	}

}