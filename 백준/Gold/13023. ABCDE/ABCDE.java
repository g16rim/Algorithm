import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, result;
	static List<Integer>[] friends;
	static boolean[] visited;
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		friends = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			friends[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friends[a].add(b);
			friends[b].add(a);
		}
		for (int i = 0; i < N; i++) {
			if (flag) break;
			visited[i] = true;
			dfs(0, i);			
			visited[i] = false;
		}
		System.out.println(result);
	}
	
	static void dfs(int cnt, int idx) {
		if (cnt == 4) {
			result = 1;
			flag = true;
			return;
		}
		
		for (int i = 0; i < friends[idx].size(); i++) {
			int next = friends[idx].get(i);
			if (visited[next] == false) {
				visited[next] = true;
				if (flag) return;
				dfs(cnt + 1, next);
				visited[next] = false;
			}
		}
	}

}