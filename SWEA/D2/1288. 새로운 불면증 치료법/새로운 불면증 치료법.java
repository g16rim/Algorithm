import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int result = 1, bit = 0;
			int N = Integer.parseInt(br.readLine());
			
			while (true) {				
				int x = N * result;
				while (x > 0) {
					int temp = x % 10;
					bit = (bit | (1 << temp));
					x = x / 10;
				}
				
				if ((bit & ((1 << 10) - 1)) == ((1 << 10) - 1)) {					
					break;
				}
				
				result++;
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(result * N);
			System.out.println(sb);
		}
	}

}