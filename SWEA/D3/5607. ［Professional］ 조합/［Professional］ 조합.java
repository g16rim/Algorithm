import java.io.*;
import java.util.*;

public class Solution {
	static int n, r;
	static final int R = 1234567891;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			// n!*(r!(n-r)!)^(p-2)
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			long[] fac = new long[n + 1];
			fac[0] = 1;
			for (int i = 1; i <= n; i++)
				fac[i] = (fac[i - 1] * i) % R;
			long bottom = (fac[n - r] * fac[r]) % R;
			long answer = (fac[n] * pow(bottom, R - 2)) % R;
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	private static long pow(long x, int y) { // x^y (mod R)
		if (y == 0) return 1;
		long tmp = pow(x, y / 2);
        long ret = (tmp * tmp) % R;
		if (y % 2 == 0) return ret;
		else return (ret * x) % R;
	}
}