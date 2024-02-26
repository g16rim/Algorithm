import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
//		System.out.println(Arrays.deepToString(arr));
		
		visited[1] = true;
		dfs(1);
		int result = 0;
		
//		System.out.println(Arrays.toString(visited));
		
		for (int i = 2; i <= N; i++) if (visited[i] == true) result++;
		System.out.println(result);
	}
	
	static void dfs(int n) {
		for (int i = 1; i <= N; i++) {
			if (visited[i] == true) continue;
			if (arr[n][i] == 1) {
				visited[i] = true;
				dfs(i);	
			}
		}
	}

}