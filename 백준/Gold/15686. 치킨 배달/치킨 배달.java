import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, result, answer;
	static int[][] city;
	static List<int[]> chickenHouse = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		city = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if (city[i][j] == 2) chickenHouse.add(new int[] {i, j});
			}
		}
		visited = new boolean[chickenHouse.size()];
		answer = Integer.MAX_VALUE;
		pickChickenHouse(0, 0);
		System.out.println(answer);
	}
	
	static void pickChickenHouse(int idx, int size) {
		if (size == M) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (city[i][j] == 1) {
						calcChickenDist(i, j);
					}
				}
			}
			answer = Math.min(answer, result);
			result = 0;
			return;
		}
		
		if (idx >= chickenHouse.size()) return;
		
		visited[idx] = true;
		pickChickenHouse(idx + 1, size + 1);
		
		visited[idx] = false;
		pickChickenHouse(idx + 1, size);
	}
	
	static void calcChickenDist(int x, int y) {
		int temp = Integer.MAX_VALUE;
		for (int i = 0; i < chickenHouse.size(); i++) {
			if (visited[i] == false) continue;
			temp = Math.min(temp, getDistance(x, y, chickenHouse.get(i)[0], chickenHouse.get(i)[1]));
		}
		result += temp;
	}
	
	static int getDistance(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
	
}