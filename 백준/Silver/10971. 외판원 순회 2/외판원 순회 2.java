import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N, city[][], arr[], dist[];
	private static boolean visited[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		city = new int[N][N];
		arr = new int[N];
		visited = new boolean[N];
		dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		printList(city);		
		for (int i = 0; i < N; i++) {
			arr[0] = i;
			visited[i] = true;
			perm(i, 1, 0);
			visited[i] = false;
		}
//		System.out.println(Arrays.toString(dist));
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			if (result > dist[i]) result = dist[i];
		}
		System.out.println(result);
	}
	
	private static void perm(int start, int cnt, int sum) {
		if (cnt == N) {
//			System.out.println(Arrays.toString(dist));
			if (city[arr[cnt - 1]][arr[0]] == 0) return;
			dist[start] = Math.min(dist[start], sum + city[arr[cnt - 1]][arr[0]]);
			return;
		}
		
		if (sum > dist[start]) return;
		
		for (int i = 0; i < N; i++) {
			if (visited[i] == true) continue;
			if (city[arr[cnt - 1]][i] == 0) return;
			arr[cnt] = i;
			visited[i] = true;
			perm(start, cnt + 1, sum + city[arr[cnt - 1]][i]);
			visited[i] = false;
		}
	}
	
	private static void printList(int [][] a) {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(a[i]));
		}
	}
}