import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, r, c, cnt;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int size = (int) Math.pow(2, N);
		recur(size, 0, 0);
		
		System.out.println(cnt);
	}
	
	private static void recur(int size, int x, int y) {
		
		if (size == 2) {
			if (r == x && c == y + 1) cnt += 1;
			else if (r == x + 1 && c == y) cnt += 2;
			else if (r == x + 1 && c == y + 1) cnt += 3;
			
			return;
		}
		
		int ns = size / 2;
		
		// 필요할 때만(r, c가 새로운 범위 안) 재귀 타기
		if (r < x + ns && c < y + ns) {
			recur(ns, x, y);
		}
		else if (r < x + ns && c < y + size) {
			cnt += (size * size) / 4;
			recur(ns, x, y + ns);
		}
		else if (r < x + size && c < y + ns) {
			cnt += (size * size) / 4 * 2;
			recur(ns, x + ns, y);
		}
		else if (r < x + size && c < y + size) {
			cnt += (size * size) / 4 * 3;
			recur(ns, x + ns, y + ns);
		}
		
	}
	
}