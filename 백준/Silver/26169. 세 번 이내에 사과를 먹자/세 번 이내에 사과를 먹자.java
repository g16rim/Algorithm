import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] board = new int[5][5];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		bt(r, c, 0, 0);
		System.out.println(result);
	}

	private static void bt(int r, int c, int move, int apple) {
		if (move > 3) {
			result = 0;
		}

		if (apple >= 2) {
			result = 1;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || board[nr][nc] == -1) {
				continue;
			}

			if (board[r][c] == 1) {
				board[r][c] = -1; // 방문 처리
				bt(nr, nc, move + 1, apple + 1);
				board[r][c] = 1;
			} else {
				board[r][c] = -1; // 방문 처리
				bt(nr, nc, move + 1, apple);
				board[r][c] = 0;
			}
		}
	}

}