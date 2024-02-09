import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static Stack<Integer> result = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        solve(0);

        System.out.println(sb);

    }

    static void solve(int cnt) {

        if (cnt == M) {
            for (int r : result) {
                sb.append(r).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            result.add(i);
            solve(cnt + 1);
            result.pop();
        }

    }

}