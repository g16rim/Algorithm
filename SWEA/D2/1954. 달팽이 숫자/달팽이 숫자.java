import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
			
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append("\n");
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(arr[i], 0);				
			}
			
			int x = 0, y = 0, dir = 0;
			int cnt = 1;
			while (cnt <= N * N) {
				arr[x][y] = cnt++;
				
				// dir 조정
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if (nx >= 0 && ny >= 0 && nx < N && ny < N && arr[nx][ny] == 0) {
					x += dx[dir];
					y += dy[dir];
				} else {
					dir++;
					if (dir > 3) dir = 0;
					x += dx[dir];
					y += dy[dir];
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}

}