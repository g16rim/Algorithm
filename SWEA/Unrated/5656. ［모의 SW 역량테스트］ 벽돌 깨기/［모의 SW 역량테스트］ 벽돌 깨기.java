import java.io.*;
import java.util.*;

public class Solution {
	static int n, w, h, orig[][], arr[][], perm[], result;
	static int dr[] = { -1, 1, 0, 0 }, dc[] = { 0, 0, -1, 1 };
	static Queue<Position> q;

	static class Position {
		int r, c, n;

		Position(int r, int c, int n) {
			this.r = r;
			this.c = c;
			this.n = n;
		}

		@Override
		public String toString() {
			return "Position [r=" + r + ", c=" + c + ", n=" + n + "]";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			perm = new int[n];
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			orig = new int[h][w];
			arr = new int[h][w];
			q = new ArrayDeque<>();
			result = Integer.MAX_VALUE;
			for (int r = 0; r < h; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < w; c++) {
					orig[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			simulate();
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
	}

	static void simulate() {
		pickBricks(0); // perm[]: 순서 담김
	}

	static void pickBricks(int cnt) {
		if (result == 0)
			return;

		if (cnt == n) {
			copyArr();
			pokBal();
			countBricks();
//			print();
			return;
		}

		for (int i = 0; i < w; i++) {
			perm[cnt] = i;
			pickBricks(cnt + 1);
		}
	}

	static void countBricks() {
		int sum = 0;
		for (int r = 0; r < h; r++) {
			for (int c = 0; c < w; c++) {
				if (arr[r][c] > 0)
					sum++;
			}
		}
		result = Math.min(result, sum);
	}

	static void pokBal() {
		for (int i = 0; i < n; i++) {
			bfs(perm[i]);
			moveBricks();
		}
	}

	static void copyArr() {
		for (int r = 0; r < h; r++) {
			for (int c = 0; c < w; c++) {
				arr[r][c] = orig[r][c];
			}
		}
	}

	static void moveBricks() {
		for (int c = 0; c < w; c++) {
			boolean flag = false;
			for (int r = h - 1; r >= 0; r--) {
				if (arr[r][c] == 0) {
					// 위에 벽돌 있는지 찾아보기
					int t = r - 1;
					while (t >= 0) {
						if (arr[t][c] > 0) {
							arr[r][c] = arr[t][c];
							arr[t][c] = 0;
							break;
						}
						t--;
						if (t == -1)
							flag = true;
					}
				}
				if (flag)
					break;
			}
		}
	}

	static void bfs(int n) {
		// n열 맨 위 벽돌 찾기
		int x = 0;
		while (true) {
			if (arr[x][n] > 0) {
				q.add(new Position(x, n, arr[x][n]));
				break;
			}
			x++;
			if (x == h)
				break;
		}
		while (!q.isEmpty()) {
			Position now = q.poll();
			arr[now.r][now.c] = 0;
			for (int i = 1; i < now.n; i++) {
				for (int j = 0; j < 4; j++) {
					int nr = now.r + dr[j] * i;
					int nc = now.c + dc[j] * i;
					if (inRange(nr, nc)) {
						if (arr[nr][nc] > 1)
							q.add(new Position(nr, nc, arr[nr][nc]));
						arr[nr][nc] = 0;
					}
				}
			}
		}
	}

	static boolean inRange(int r, int c) {
		return r >= 0 && r < h && c >= 0 && c < w && arr[r][c] != 0;
	}

	static void print() {
		System.out.println("=====================");
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}