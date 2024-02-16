import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int a, b, result = -1;
	static boolean[] visited;
	static List<Integer>[] list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}
		visited = new boolean[n + 1];
		visited[a] = true;
		dfs(a, 0);
		System.out.println(result);
	}
	
	static void dfs(int index, int depth) {
		if (index == b) {
			result = depth;
			return;
		}
		
		for (int i = 0; i < list[index].size(); i++) {
			int node = list[index].get(i);
			if (visited[node] == true) continue;
			visited[node] = true;
			dfs(node, depth + 1);
			visited[node] = false;
		}
	}

}