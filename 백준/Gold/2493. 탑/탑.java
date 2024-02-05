import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int index;
        int height;

        Node() {}

        Node(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Stack<Node> stack = new Stack<>();
        for (int i = 1; i <= N; i++) {
            int temp = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) {
                sb.append("0 ");
                stack.add(new Node(i, temp));
            } else {

                while (!stack.isEmpty() && stack.peek().height <= temp) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    sb.append("0 ");
                } else {
                    sb.append(stack.peek().index).append(" ");
                }

                stack.add(new Node(i, temp));

            }


        }
        System.out.println(sb);
    }

}