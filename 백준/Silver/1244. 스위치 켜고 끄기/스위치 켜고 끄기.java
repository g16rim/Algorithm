import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			
			if (gender == 1) { // 남자
				for (int i = index; i <= N; i += index) {
					if (arr[i] == 0) arr[i] = 1;
					else arr[i] = 0;
				}
			} else { // 여자
				int size = 1;
				while (true) {
					if (index - size <= 0 || index + size > N) break;
					if (arr[index - size] == arr[index + size]) size++;
					else break;
				}
				
				if (arr[index] == 0) arr[index] = 1;
				else arr[index] = 0;
				for (int i = 1; i < size; i++) {
					if (arr[index + i] == 0) {
						arr[index + i] = 1;
						arr[index - i] = 1;
					} else {
						arr[index + i] = 0;
						arr[index - i] = 0;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (i % 20 == 0) {
				sb.append(arr[i]).append("\n");
			} else {
				sb.append(arr[i]).append(" ");
			}
			
		}
		System.out.println(sb);
	}
	
}