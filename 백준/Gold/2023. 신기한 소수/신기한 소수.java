import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		solve(1, 2);
		solve(1, 3);
		solve(1, 5);
		solve(1, 7);
		
		System.out.println(sb);
	}
	
	private static void solve(int len, int num) {
		if (len == N) {
			sb.append(num).append("\n");
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			int temp = num * 10 + i;
			
			if (isPrime(temp) == true) solve(len + 1, temp); 
 		}
	}

	private static boolean isPrime(int num) {
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) return false; 
		}
		return true;
	}
	
}