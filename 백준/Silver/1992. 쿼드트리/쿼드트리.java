import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static String[] input;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		input = new String[N];
		for (int i = 0; i < N; i++) {
			input[i] = br.readLine();
		}
		
		if (allSame(N, 0, 0) == true) {
			sb.append(input[0].charAt(0));
		} else dnq(N, 0, 0);
		System.out.println(sb);
		
	}
	
	static void dnq(int size, int x, int y) {
		
		if (size == 2) {
			sb.append("(");
			sb.append(input[x].charAt(y)).append(input[x].charAt(y + 1))
			.append(input[x + 1].charAt(y)).append(input[x + 1].charAt(y + 1));
			sb.append(")");
			return;
		}
		
		// 각 사분면 확인
		int ns = size / 2;
		sb.append("(");
		if (allSame(ns, x, y)) {
			sb.append(input[x].charAt(y));
		} else {
			dnq(ns, x, y);
		}
		if (allSame(ns, x, y + ns)) {
			sb.append(input[x].charAt(y + ns));
		} else {
			dnq(ns, x, y + ns);
		}
		if (allSame(ns, x + ns, y)) {
			sb.append(input[x + ns].charAt(y));
		} else {
			dnq(ns, x + ns, y);
		}
		if (allSame(ns, x + ns, y + ns)) {
			sb.append(input[x + ns].charAt(y + ns));
		} else {
			dnq(ns, x + ns, y + ns);
		}
		
		sb.append(")");
		return;
		
	}
	
	static boolean allSame(int size, int x, int y) {
		
		char pivot = input[x].charAt(y);
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (pivot != input[i].charAt(j)) return false;
			}
		}
		
		return true;
		
	}

}