import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, sour[], bitter[], result = 1_000_000_000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		
		generateSubSet(0, 1, 0);
		
		System.out.println(result);
	}
	
	private static void generateSubSet(int cnt, int sourFlavor, int bitterFlavor) {
		if (cnt > 0 && sourFlavor != 1 && bitterFlavor != 0) {
			result = Math.abs(sourFlavor - bitterFlavor) < result ? Math.abs(sourFlavor - bitterFlavor) : result;			
		}

		if (cnt == N) {
			return;
		}
		
		generateSubSet(cnt + 1, sourFlavor * sour[cnt], bitterFlavor + bitter[cnt]);
		generateSubSet(cnt + 1, sourFlavor, bitterFlavor);
	}

}