import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int w, h, count;
	static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
	static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};
	
	public static void main(String[] args) throws Exception {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) break;
			
			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						bfs(i, j);
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		map[x][y] = 0;
		q.add(new int[] {x, y});
		
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			for (int i = 0; i < 8; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= h || ny >= w || map[nx][ny] == 0) continue;
				
				map[nx][ny] = 0;
				q.add(new int[] {nx, ny});
			}
		}
		count++;
	}

}