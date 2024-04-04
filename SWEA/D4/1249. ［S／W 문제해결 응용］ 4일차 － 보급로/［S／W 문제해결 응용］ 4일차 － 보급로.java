import java.io.*;
import java.util.*;

public class Solution {
	static int n, dist[][];
	static int arr[][];
	static int dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			dist = new int[n][n];
			char ch[] = new char[n];
			for (int i= 0; i < n; i++) {
				ch = br.readLine().toCharArray();
				for (int j = 0; j < n; j++) {
					arr[i][j] = ch[j] - '0';
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			dijkstra();
			sb.append("#").append(tc).append(" ").append(dist[n - 1][n - 1]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		pq.add(new int[] {0, 0, arr[0][0]});
		dist[0][0] = 0;
		
		while (!pq.isEmpty()) {
			int[] temp = pq.poll();
			int x = temp[0];
			int y = temp[1];
			int cost = temp[2];
			
			if (dist[x][y] < cost) continue;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (!inRange(nx, ny)) continue;
				
				if (dist[nx][ny] > dist[x][y] + arr[nx][ny]) {
					dist[nx][ny] = dist[x][y] + arr[nx][ny];
					pq.add(new int[] {nx, ny, dist[nx][ny]});
				}
			}
		}
	}
	
	static boolean inRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
}