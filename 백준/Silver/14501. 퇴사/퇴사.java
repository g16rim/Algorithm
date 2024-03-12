import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int n, t[], p[], dp[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		t = new int[n + 1];
		p = new int[n + 1];
		dp = new int[n + 2];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= n; i++) {
			dp[i] = Math.max(dp[i], dp[i - 1]);
			if (i + t[i] <= n + 1) dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
		}
		
//		System.out.println(Arrays.toString(dp));
		dp[n + 1] = Math.max(dp[n + 1], dp[n]);
		System.out.println(dp[n + 1]);
	}
}