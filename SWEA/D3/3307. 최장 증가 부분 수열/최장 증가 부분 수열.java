import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, arr[], LIS[], result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			LIS = new int[n];
			result = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				LIS[i] = 1;
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < i; j ++) {
					if (arr[j] < arr[i] && LIS[i] < LIS[j] + 1)
						LIS[i] = LIS[j] + 1;
				}
				result = Math.max(result, LIS[i]);
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}		
		System.out.print(sb);
	}
}