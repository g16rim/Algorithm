import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static List<Integer> arr = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	static int[] visited = new int[10];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) { // 시작하는 숫자 for문
			arr.add(i);
			visited[i] = 1;
			bt(1);		
			arr.clear();
			Arrays.fill(visited, 0);
		}

		System.out.println(sb);
	}

	private static void bt(int count) {
		if (count == M) {
			for (int i = 0; i < arr.size(); i++) {
				sb.append(arr.get(i)).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (visited[i] == 1)
				continue;
			arr.add(i);
			visited[i] = 1;
			bt(count + 1);
			visited[arr.get(arr.size() - 1)] = 0;
			arr.remove(arr.size() - 1);
		}
	}

}