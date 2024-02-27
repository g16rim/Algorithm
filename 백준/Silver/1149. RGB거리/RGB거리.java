import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] rgb;
	static int[][] result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		rgb = new int[N][N];
		result = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result[0][0] = rgb[0][0];
		result[0][1] = rgb[0][1];
		result[0][2] = rgb[0][2];
		
		for (int i = 1; i < N; i++) {
			result[i][0] = rgb[i][0] + Math.min(result[i - 1][1], result[i - 1][2]);
			result[i][1] = rgb[i][1] + Math.min(result[i - 1][0], result[i - 1][2]);
			result[i][2] = rgb[i][2] + Math.min(result[i - 1][0], result[i - 1][1]);
		}
		
		System.out.println(Math.min(result[N - 1][0], Math.min(result[N - 1][1], result[N - 1][2])));
	}
}