import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] top = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) top[i] = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek()[0] <= top[i]) {
                stack.pop(); // 현재 탑보다 낮은 탑 제거
            }
            
            if (stack.isEmpty()) {
                sb.append("0 ");
            } else {
                sb.append(stack.peek()[1]).append(" ");
            }
            
            stack.push(new int[] {top[i], i + 1});
        }
        
        System.out.println(sb);
    }
}
