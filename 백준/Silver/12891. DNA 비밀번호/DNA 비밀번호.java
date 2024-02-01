import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int result;
	static String input;
	static int[] comp = new int[4]; // 비교해야 할 ACGT 개수
	static int[] alp = new int[4]; // 현재 ACGT 개수

	public static void main(String[] args) throws Exception {
		String ch = "ACGT";
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		input = br.readLine();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			comp[i] = Integer.parseInt(st.nextToken());
		}
		
		// 젤 처음 계산
		for (int i = 0; i < 4; i++) {
			alp[i] = findChar(0, P, ch.charAt(i));
		}
		
		check();
		
		for (int i = 1; i < S - P + 1; i++) {
			int first = ch.indexOf(input.charAt(i - 1));
			alp[first]--;
			int last = ch.indexOf(input.charAt(i - 1 + P));
			alp[last]++;

			check();
		}
		
		System.out.println(result);
		
	}



	private static void check() {
		for (int j = 0; j < 4; j++) {
			if (alp[j] < comp[j]) break;
			if (j == 3) result++;
		}
	}
	
	
	
	private static int findChar(int start, int end, char compCh) {
		int count = 0;
		
		for (int i = start; i < end; i++) {
			if (input.charAt(i) == compCh) {
				count++;
			}
		}
		
		return count;
	}
}