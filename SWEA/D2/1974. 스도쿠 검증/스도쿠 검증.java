import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] board = new int[9][9];
	static int result;
	static int[] check = new int[10];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			// 입력
			StringTokenizer st;
			StringBuilder sb = new StringBuilder();
			result = 1;
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 검증
			solve();
			Arrays.fill(check, 0);
			
			// 출력
			sb.append("#").append(tc).append(" ").append(result);
			System.out.println(sb);
		}
	}

	private static void solve() {
		// 가로
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (check[board[i][j]] == (i + 1)) { // 중복 발생
					result = 0;
					return;
				}
				check[board[i][j]]++;
			}
		}
		Arrays.fill(check, 0);
		
		// 세로
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (check[board[j][i]] == (i + 1)) { // 중복 발생
					result = 0;
					return;
				}
				check[board[j][i]]++;
			}
		}
		Arrays.fill(check, 0);
		
		// 3X3
		int order = 0;
		for (int a = 0; a < 9; a += 3) {
			for (int b = 0; b < 9; b += 3) {				
				for (int i = a; i < a + 3; i++) {
					for (int j = b; j < b + 3; j++) {
						if (check[board[i][j]] != order) {
							result = 0;
							return;
						}
						check[board[i][j]]++;
					}
				}
				order++;
			}
		}
		Arrays.fill(check, 0);
	}
	
}