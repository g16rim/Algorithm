import java.io.*;
import java.util.*;

public class Main {
	static char arr[][];
	static boolean visited[][];
	static Queue<Position> stars = new ArrayDeque<>();
	static Queue<Position> s = new ArrayDeque<>();
	static int R, C, dr[] = { -1, 1, 0, 0 }, dc[] = { 0, 0, -1, 1 }, result;

	static class Position {
		int r, c, cnt;

		Position(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Position [x=" + r + ", y=" + c + ", cnt=" + cnt + "]";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == '*')
					stars.add(new Position(i, j, 1));
				else if (arr[i][j] == 'S') {
					s.add(new Position(i, j, 1));
					visited[i][j] = true;
					arr[i][j] = '.';
				}
			}
		}
		bfs();
		if (result != 0) System.out.println(result);
		else {
			System.out.println("KAKTUS");
		}
	}

	static void bfs() {
		int n = 1;
		while (!stop()) {
//			System.out.println("turn: " + n);
//			System.out.println("=================================================");
			waterBfs(n);
//			print();
			dochiBfs(n++);
//			print();
			if (result != 0) return;
		}
//		print();
	}
	
	static boolean stop() {
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				if (arr[i][j] == '.' || arr[i][j] == 'S') return false;
//			}
//		}
//		return true;
		return s.isEmpty();
	}

	static void waterBfs(int n) {
//		System.out.println("waterBfs");
		while (!stars.isEmpty()) {
			if (stars.peek().cnt > n) return;
			Position temp = stars.poll();

			for (int i = 0; i < 4; i++) {
				int nr = temp.r + dr[i];
				int nc = temp.c + dc[i];

				if (isWaterPossible(nr, nc)) {
					stars.add(new Position(nr, nc, temp.cnt + 1));
					arr[nr][nc] = '*';
				}
			}
		}
	}

	static boolean isWaterPossible(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C && (arr[r][c] == '.' || arr[r][c] == 'S');
	}

	static void dochiBfs(int n) {
//		System.out.println("dochiBfs");
		while (!s.isEmpty()) {
			if (s.peek().cnt > n) return;
			Position temp = s.poll();
			for (int i = 0; i < 4; i++) {
				int nr = temp.r + dr[i];
				int nc = temp.c + dc[i];

				if (isDochiPossible(nr, nc)) {
					if (arr[nr][nc] == 'D') {
						result = temp.cnt;
//						System.out.println("찾았다!!!");
						return;
					} else if (arr[nr][nc] == '.') {
						visited[nr][nc] = true;
						s.add(new Position(nr, nc, temp.cnt + 1));
						arr[nr][nc] = 'S';
					}
				}
			}
		}
	}

	static boolean isDochiPossible(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C && (arr[r][c] == '.' || arr[r][c] == 'D') && visited[r][c] == false;
	}

	static void print() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(arr[r][c]);
			}
			System.out.println();
		}
	}

//	static void printStars() {
//		for (int i = 0; i < stars.size(); i++)
//			System.out.println(stars.get(i).toString());
//	}
}