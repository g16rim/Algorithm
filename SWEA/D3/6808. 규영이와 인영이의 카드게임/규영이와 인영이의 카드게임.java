import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	// 9! = 362880
	static int[] gyuYoung = new int[9];
	static int[] gyuYoungVisited = new int[19];
	static List<Integer> inYoung = new ArrayList<>();
	static int result;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			result = 0;
			gyuYoungVisited = new int[19];
			inYoung.clear();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				gyuYoung[i] = Integer.parseInt(st.nextToken());
				gyuYoungVisited[gyuYoung[i]] = 1;
			}
						
			compare(0);
			
			sb.append("#").append(tc).append(" ").append(result).append(" ").append(362880 - result).append("\n");			
		}
		
		System.out.println(sb);
		
	}
	
	static void compare(int cnt) {
		
		if (cnt == 9) {
			// result 계산
			int tempA = 0, tempB = 0;
			for (int i = 0; i < 9; i++) {
				if (gyuYoung[i] > inYoung.get(i)) {
					tempA += (gyuYoung[i] + inYoung.get(i));
				} else {
					tempB += (gyuYoung[i] + inYoung.get(i));
				}
			}
			
			if (tempA > tempB) result++;
			
			return;
			
		}
		
		for (int i = 1; i <= 18; i++) {
			if (gyuYoungVisited[i] == 0) {
				inYoung.add(i);
				gyuYoungVisited[i] = 2;
				compare(cnt + 1);
				gyuYoungVisited[i] = 0;
				inYoung.remove(inYoung.size() - 1);				
			}
		}
		
	}
	
}