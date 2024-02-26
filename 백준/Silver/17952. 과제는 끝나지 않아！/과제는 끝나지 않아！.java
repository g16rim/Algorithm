import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int result;
	
	static class Task {
		int score;
		int remain;
		
		public Task(int score, int remain) {
			this.score = score;
			this.remain = remain;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Stack<Task> s = new Stack<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			if (command == 0) {
				// stack peek
				if (!s.isEmpty() && s.peek() != null) {
					Task t = s.pop();
					if (--t.remain == 0) result += t.score;
					else s.add(new Task(t.score, t.remain));
				}
				continue;
			}
			int score = Integer.parseInt(st.nextToken());
			int remain = Integer.parseInt(st.nextToken());
			if (--remain == 0) result += score;
			else {
				s.add(new Task(score, remain));
			}
		}
		System.out.println(result);
	}

}