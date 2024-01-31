import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			list.add(i);
			permutation(i, 1);
			list.remove(list.size() - 1);
		}
		
		System.out.println(sb);
	}

	private static void permutation(int idx, int qty) {
		if (qty == M) {
			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i)).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = idx + 1; i <= N; i++) {
			list.add(i);
			permutation(i, qty + 1);
			list.remove(list.size() - 1);
		}
	}
}