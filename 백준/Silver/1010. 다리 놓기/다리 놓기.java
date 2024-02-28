import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int[][] B = new int[N + 1][M + 1];
			
			for (int i = 0; i <= N; i++) {
				for (int j = 0, end = Math.min(i, M); j <= end; j++) {
					if (j == 0 || j == i) B[i][j] = 1;
					else B[i][j] = B[i - 1][j - 1] + B[i - 1][j];
				}
			}
			
			sb.append(B[N][M]).append("\n");
		}
		System.out.println(sb);
	}
}