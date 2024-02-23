import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, d, k, c, result;
	static int[] arr;
	static Queue<Integer> my = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		arr = new int[d + 1];
		k = Integer.parseInt(st.nextToken());
		List<Integer> rail = new ArrayList<>();
		c = Integer.parseInt(st.nextToken());
		arr[c] = 1;
		
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			rail.add(input);
			if (i < k) {
				my.add(input);
				arr[input] += 1;
			}
			if (i == k - 1) result = checkOne();
		}
		rail.addAll(rail);
		
		int sum = result;
		for (int i = 1; i < N; i++) {
			int first = my.poll();
			arr[first] -= 1;
			if (arr[first] == 0) sum--;
			
			int last = rail.get(i + k - 1);
			my.add(last);
			arr[last] += 1;
			if (arr[last] == 1) sum++; 
			
			result = Math.max(sum, result);
		}
		
		System.out.println(result);
	
	}
	
	static int checkOne() {
		int sum = 0;
		for (int i = 1; i <= d; i++) {
			if (arr[i] != 0) sum++;
		}
		return sum;
	}

}