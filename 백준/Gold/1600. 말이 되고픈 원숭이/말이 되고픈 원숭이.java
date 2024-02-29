import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int K, W, H, result = Integer.MAX_VALUE;
	static int[][] arr;
	static int[] hx = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int[] hy = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] mx = { -1, 1, 0, 0 };
	static int[] my = { 0, 0, -1, 1 };
	static boolean[][][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		if (H == 1 ||  W == 1) {
//			System.out.println(result);
//			return;
//		}
//		bfs();
//		if (result == Integer.MAX_VALUE) result = -1;
//		System.out.println(result);
		System.out.println(bfs());
	}

	static int bfs() {
		visited = new boolean[H][W][K + 1];
		Queue<int[]> q = new ArrayDeque<>();
		visited[0][0][0] = true;
		q.add(new int[] { 0, 0, 0, 0 });

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int x = temp[0];
			int y = temp[1];
			int kCnt = temp[2];
			int cnt = temp[3];
			
			if (x == H - 1 && y == W - 1) {
//				result = Math.min(result, cnt);
				return cnt;
			}
			
			if (kCnt < K) {
				for (int i = 0; i < 8; i++) {
					int nx = x + hx[i];
					int ny = y + hy[i];

					if (nx < 0 || ny < 0 || nx >= H || ny >= W || arr[nx][ny] == 1 || visited[nx][ny][kCnt + 1] == true)
						continue;

					visited[nx][ny][kCnt + 1] = true;
					q.add(new int[] { nx, ny, kCnt + 1, cnt + 1 });
				}
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + mx[i];
				int ny = y + my[i];

				if (nx < 0 || ny < 0 || nx >= H || ny >= W || arr[nx][ny] == 1 || visited[nx][ny][kCnt] == true)
					continue;

				visited[nx][ny][kCnt] = true;
				q.add(new int[] { nx, ny, kCnt, cnt + 1 });
			}
		}
		return -1;
	}
}