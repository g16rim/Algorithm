import java.io.*;
import java.util.*;

public class Solution {
	static int n, m, arr1[][], arr2[][], cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());
			arr1 = new int[n + 1][n + 1];
			arr2 = new int[n + 1][n + 1];
			int result = 0;

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr1[a][b] = 1;
				arr2[b][a] = 1;
			}
			
			for (int i = 1; i <= n; i++) {
				cnt = 0;
				dfs(i, arr1, new boolean[n + 1]);
				dfs(i, arr2, new boolean[n + 1]);
				if (cnt == n - 1) result++;
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
	}

	static void dfs(int s, int[][] arr, boolean[] visited) {
		visited[s] = true;
		for (int i = 1; i <= n; i++) {
			if (arr[s][i] == 1 && !visited[i]) {
				cnt++;
				dfs(i, arr, visited);
			}
		}
	}
}