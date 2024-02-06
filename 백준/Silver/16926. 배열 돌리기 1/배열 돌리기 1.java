import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, R;
	static int[][] arr;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(0, 0, 0);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void solve(int x, int y, int level) {
		if (level == N / 2 || level == M / 2) return;

		Deque<Integer> q = new ArrayDeque<>();		
		int size = level * 2;
		
		for (int j = y; j < y + M - size; j++) { // -
			q.add(arr[x][j]);
		}
		q.pollLast();
		
		for (int i = x; i < x + N - size; i++) { // |
			q.add(arr[i][y + M - size - 1]);
		}
		q.pollLast();
		
		for (int j = y + M - 1 - size; j >= y; j--) { // -
			q.add(arr[x + N - size - 1][j]);
		}
		q.pollLast();
		
		for (int i = x + N - 1 - size; i >= x; i--) { // |
			q.add(arr[i][y]);
		}
		q.pollLast();
		
		for (int i = 0; i < R; i++) {
			q.add(q.pollFirst());
		}
		
		for (int j = y; j < y + M - size; j++) { // -
			arr[x][j] = q.pollFirst();
		}
		
		for (int i = x + 1; i < x + N - size; i++) { // |
			arr[i][y + M - size - 1] = q.pollFirst();
		}
		
		for (int j = y + M - 2 - size; j >= y; j--) { // -
			arr[x + N - size - 1][j] = q.pollFirst();
		}
		
		for (int i = x + N - 2 - size; i >= x + 1; i--) { // |
			arr[i][y] = q.pollFirst();
		}
		
		solve(x + 1, y + 1, level + 1);
		
	}
	
}