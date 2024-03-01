import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            if (dp[N] > 0) {
                sb.append(dp[N]).append("\n");
                continue;
            }
            for (int i = 4; i <= N; i++) {
                dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
            }
            sb.append(dp[N]).append("\n");
        }
        System.out.print(sb);
    }
}