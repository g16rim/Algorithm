import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static Queue<int []> q = new ArrayDeque<>();
	static int M, N, result;
	static int[][] box;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		addQueue();
		bfs();
		if (!checkStatus()) result = -1; 
		System.out.println(result);
	}
	
	static void addQueue() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 1) q.add(new int[] {i, j, 0});
			}
		}
	}
	
	static boolean checkStatus() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) return false;
			}
		}
		return true;
	}
	
	static void bfs() {
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				int day = temp[2];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || box[nx][ny] == -1) continue;
				
				if (box[nx][ny] == 0) {
					box[nx][ny] = 1;
					q.add(new int[] {nx, ny, day + 1});
					result = temp[2] + 1;
				}
			}
		}
		
	}
}