import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[101][101];
		StringTokenizer st;
		
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					paper[i][j] = 1;
				}
			}
			
		}
		
		int result = 0;
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				result += paper[i][j];
			}
		}
		
		System.out.println(result);
		
	}
	
}