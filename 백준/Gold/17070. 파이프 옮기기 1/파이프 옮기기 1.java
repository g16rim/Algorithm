import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, result;
	static int[][] arr;
	static int[] dx = {0, 1, 1};
	static int[] dy = {1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 1, 0);
		System.out.println(result);
	}
	
	static void dfs(int x, int y, int dir) {
		if (x == N - 1 && y == N - 1) {
			result++;
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			if ((dir == 0 && i == 1) || (dir == 1 && i == 0)) continue;
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 범위 밖
			if (nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] == 1) continue;	
			
			if (i == 2 && !(arr[nx][ny - 1] == 0 && arr[nx - 1][ny] == 0)) continue;
				
			dfs(nx, ny, i);
		}
	}
}