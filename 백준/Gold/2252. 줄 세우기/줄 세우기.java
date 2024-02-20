import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] listArr;
	static int[] depth;
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		listArr = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			listArr[i] = new ArrayList<Integer>();
		}
		depth = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			listArr[a].add(b);
			depth[b]++;
		}
		
		solve();
		System.out.print(sb);
	}
	
	private static void solve() {
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (depth[i] == 0) {
				q.add(i);
			}
		}
		
		while (!q.isEmpty()) {
			int num = q.poll();
			
			if (depth[num] == 0) {
				sb.append(num).append(" ");
			}
			for (int i = 0; i < listArr[num].size(); i++) {
				int x = listArr[num].get(i);
				depth[x]--;
				if (depth[x] == 0)
					q.add(x);
			}
		}
	}

}