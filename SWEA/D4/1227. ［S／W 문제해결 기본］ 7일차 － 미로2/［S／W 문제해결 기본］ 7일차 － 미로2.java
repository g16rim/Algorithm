import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
	
	static char[][] map = new char[100][100];
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static Point start, end;
	static int result;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			for (int i = 0; i < 100; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			findStartAndEnd();
			result = 0;
			bfs();		
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void bfs() {
		Queue<Point> q = new ArrayDeque<>();
		q.add(start);
		map[start.x][start.y] = '1';
		
		while (!q.isEmpty()) {
			Point pt = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = pt.x + dx[i];
				int ny = pt.y + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= 100 || ny >= 100 || map[nx][ny] == '1') continue;
				
				if (map[nx][ny] == '3') {
					result = 1;
					return;
				}
				
				q.add(new Point(nx, ny));
				map[nx][ny] = '1';
			}
		}
	}
	
	static void findStartAndEnd() {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == '2') {
					start = new Point(i, j);
				}
				if (map[i][j] == '3') {
					end = new Point(i, j);
				}
			}
		}
	}
	
}