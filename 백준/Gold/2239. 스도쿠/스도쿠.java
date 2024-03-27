import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static boolean flag;
	static int[][] arr = new int[9][9];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			String line = br.readLine();
			char[] temp = line.toCharArray();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = temp[j] - '0';
				if (arr[i][j] == 0) N++;
			}
		}
//		print();
		backtrack(0, 0, 0);
//		print();
		System.out.print(sb);
	}
	
	static void backtrack(int r, int c, int cnt) {
		if (flag) return;
		
		if (cnt == N) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
			flag = true;
			return;
		}
		
		if (c == 9) {
			backtrack(r + 1, 0, cnt);
		}
		else {
			if (arr[r][c] == 0) {
				for (int i = 1; i <= 9; i++) {
					// 할당하기 전에 가능한지 판별하는 함수 필요
					if (!validate(i, r, c)) continue;
					arr[r][c] = i;
					backtrack(r, c + 1, cnt + 1);
					arr[r][c] = 0;
				}
			} else {
				backtrack(r, c + 1, cnt);
			}
		}
	}
	
	static boolean validate(int n, int r, int c) {
		// 가로
		for (int j = 0; j < 9; j++) 
			if (arr[r][j] == n)
				return false;
		// 세로
		for (int i = 0; i < 9; i++) 
			if (arr[i][c] == n)
				return false;
		// 3x3
		for (int i = r / 3 * 3; i < r / 3 * 3 + 3; i++) {
			for (int j = c / 3 * 3; j < c / 3 * 3 + 3; j++) {
				if (arr[i][j] == n)
					return false;
			}
		}
		return true;
	}
	
	static void print() {
		for (int i = 0; i < 9; i++) System.out.println(Arrays.toString(arr[i]));
	}
}