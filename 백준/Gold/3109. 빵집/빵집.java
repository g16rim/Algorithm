import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {-1, 0, 1};
	static int[] dy = {1, 1, 1};
	static int R, C, result;
	static char[][] pipelines;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		pipelines = new char[R][C];
		for (int i = 0; i < R; i++) {
			pipelines[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			flag = false;
			findLine(i, 0);
		}
		
		System.out.println(result);
		
	}
	
	static void findLine(int x, int y) {

		// y == C - 1
		if (y == C - 1) {
			result++;
			flag = true;
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			if (flag) return;
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || nx >= R || ny >= C) continue; // 범위 밖
			
			if (pipelines[nx][ny] == 'x') continue; // 건물
			
			pipelines[nx][ny] = 'x';
			findLine(nx, ny);
						
		}
		
	}
	
}