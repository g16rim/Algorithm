import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] x, y, clients;
	static boolean[] visited;
	static int N, comX, comY, homX, homY, result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			comX = Integer.parseInt(st.nextToken()); comY = Integer.parseInt(st.nextToken());
			homX = Integer.parseInt(st.nextToken()); homY = Integer.parseInt(st.nextToken());
			x = new int[N]; y = new int[N];
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			clients = new int[N];
			visited = new boolean[N];
			result = 20 * 100;
			calculate(0);
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void calculate(int cnt) {
		if (cnt == N) {
			int temp = Math.abs(comX - x[clients[0]]) + Math.abs(comY - y[clients[0]]);
			for (int i = 1; i < N; i++) {
				temp += (Math.abs(x[clients[i - 1]] - x[clients[i]]) + Math.abs(y[clients[i - 1]] - y[clients[i]]));
			}
			temp += (Math.abs(x[clients[N - 1]] - homX) + Math.abs(y[clients[N - 1]] - homY));
			result = Math.min(result, temp);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			clients[cnt] = i;
			visited[i] = true;
			calculate(cnt + 1);
			visited[i] = false;
		}
		
	}
}