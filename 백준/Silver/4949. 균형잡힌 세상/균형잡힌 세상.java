import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> st = new Stack<>();
		
		while (true) {
			char ch;
			String input = br.readLine();
			if (input.equals(".")) break;
			
			for (int i = 0; i < input.length(); i++) {
				ch = input.charAt(i);
				if (ch == '(' || ch == '[') {
					st.push(ch);
				} else if (ch == ')' || ch ==']') {
					if (st.isEmpty() || (ch == ']' && st.peek() == '(') || (ch == ')' && st.peek() == '[')) {
						st.push(ch);
						break;
					} else {
						st.pop();
					}
				}
			}
			
			if (st.isEmpty()) {
				sb.append("yes\n");
			} else {
				sb.append("no\n");
			}
			
			st.clear();
		}
		
		
		System.out.println(sb);
	}
	
}