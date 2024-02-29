import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, map[][], newMap[][], result, combArr[];
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	private static List<Position> zero, virus;
	
	private static class Position {
		int x, y;
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		virus = new ArrayList<>();
		zero = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virus.add(new Position(i, j));
				} else if (map[i][j] == 0) {
					zero.add(new Position(i, j));
				}
			}
		}
//		System.out.println(Arrays.deepToString(map));
		combArr = new int[3];
		comb(0, 0);
		System.out.println(result);
	}
	
	private static void copyMap() {
		newMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}
	
	private static void build() {
		for (int i = 0; i < 3; i++) {
			int x = zero.get(combArr[i]).x;
			int y = zero.get(combArr[i]).y;
			newMap[x][y] = 1;
		}
	}
	
	private static int bfs() {
		Queue<Position> q = new ArrayDeque<>();
		for (int i = 0; i < virus.size(); i++) {
			q.add(virus.get(i));
		}
		
		while (!q.isEmpty()) {
			Position temp = q.poll();
			int x = temp.x;
			int y = temp.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || newMap[nx][ny] != 0) continue;
				
				newMap[nx][ny] = 2;
				q.add(new Position(nx, ny));
			}
		}
		int result = 0;
//		System.out.println(Arrays.deepToString(map));
//		System.out.println(Arrays.deepToString(newMap));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (newMap[i][j] == 0) {
					result++;
				}
			}
		}
		return result;
	}

	private static void comb(int cnt, int idx) {
		if (cnt == 3) {
//			System.out.println(Arrays.toString(combArr));
			copyMap();
			// 벽 세우기
			build();
			// 바이러스 작업
			result = Math.max(result, bfs());
			return;
		}
		
		for (int i = idx; i < zero.size(); i++) {
			combArr[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}
}