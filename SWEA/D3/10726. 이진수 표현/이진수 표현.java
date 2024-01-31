import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			sb.append("#").append(tc).append(" ");
			int comp = (1 << N) - 1; // 마지막 N개 비트 1로 만듦
			
			comp = comp << (32 - N);
			M = M << (32 - N);
			
			if ((comp & M) == comp) {
				sb.append("ON");
			} else {
				sb.append("OFF");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
}