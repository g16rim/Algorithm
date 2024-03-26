import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, arr[][], minDist[][];
	static int dr[] = { -1, 1, 0, 0 }, dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int idx = 1;
		while (true) {
			// 입력
			n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;

			arr = new int[n][n];
			minDist = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
				Arrays.fill(minDist[i], Integer.MAX_VALUE);
			}
			minDist[0][0] = arr[0][0];
			dijkstra();
			// 출력
			sb.append("Problem ").append(idx++).append(": ").append(minDist[n - 1][n - 1]).append("\n");
		}
		System.out.println(sb);
	}

	private static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		pq.add(new int[] { 0, 0, minDist[0][0] });

		while (!pq.isEmpty()) {
			int[] temp = pq.poll();
			int r = temp[0];
			int c = temp[1];
			int w = temp[2];

			if (w > minDist[r][c])
				continue;

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (isPossible(nr, nc, w)) {
					minDist[nr][nc] = w + arr[nr][nc];
					pq.add(new int[] { nr, nc, minDist[nr][nc] });
				}
			}
		}
	}

	private static boolean isPossible(int nr, int nc, int w) {
		return nr >= 0 && nr < n && nc >= 0 && nc < n && w + arr[nr][nc] < minDist[nr][nc];
	}
}