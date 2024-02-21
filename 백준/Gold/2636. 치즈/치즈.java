import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, level, count;
	static int[][] cheese;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cheese = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (!isAllZero()) {
			bfs();			
		}
		System.out.println(level);
		System.out.println(count);
	}
	
	static boolean isAllZero() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (cheese[i][j] == 1) return false;
			}
		}
		return true;
	}
	
	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0, 0});
		count = 0;
		visited = new boolean[N][M];
		while (!q.isEmpty()) {
			int[] last = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = last[0] + dx[i];
				int ny = last[1] + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] == true) continue;
				
				if (cheese[nx][ny] == 1) {
					count++;
					visited[nx][ny] = true;
					cheese[nx][ny] = 0;
				} else if (cheese[nx][ny] == 0) {
					visited[nx][ny] = true;
					q.add(new int[] {nx, ny});
				}
			}
		}
		level++;
	}
	
}