import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	static char[][] area;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int N, normalResult, redGreenBlindnessResult;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		area = new char[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				area[i][j] = line.charAt(j);
			}
		}
		
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == false) {
					bfsNormal(area[i][j], i, j);
				}
			}
		}
//		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = false;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == false) {
					bfsRedGreenBlindness(area[i][j], i, j);
				}
			}
		}
		sb.append(normalResult).append(" ").append(redGreenBlindnessResult);
		System.out.print(sb);
	}
	
	static void bfsNormal(char ch, int x, int y) {
		Queue<int []> q = new ArrayDeque<>();
		q.add(new int[] {ch, x, y});
		visited[x][y] = true;
		while (!q.isEmpty()) {
			int[] pivot = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = pivot[1] + dx[i];
				int ny = pivot[2] + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				
				if (area[nx][ny] == (char) pivot[0] && visited[nx][ny] == false) {
					q.add(new int[] {pivot[0], nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
		normalResult++;
	}
	
	static void bfsRedGreenBlindness(char ch, int x, int y) {
		Queue<int []> q = new ArrayDeque<>();
		q.add(new int[] {ch, x, y});
		visited[x][y] = true;
		while (!q.isEmpty()) {
			int[] pivot = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = pivot[1] + dx[i];
				int ny = pivot[2] + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				
				if ((char) pivot[0] == 'R' || (char) pivot[0] == 'G') { // 빨간색 or 초록색일 경우
					if (area[nx][ny] != 'B' && visited[nx][ny] == false) {
						q.add(new int[] {pivot[0], nx, ny});
						visited[nx][ny] = true;
					}
				} else {
					if (area[nx][ny] == (char) pivot[0] && visited[nx][ny] == false) {
						q.add(new int[] {pivot[0], nx, ny});
						visited[nx][ny] = true;
					}					
				}
				
			}
		}
		redGreenBlindnessResult++;
	}

}