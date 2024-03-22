import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i == 1) dp[1] = 1;
            else if (i == 2) dp[2] = 2;
            else dp[i] = (dp[i - 1] % 10007 + dp[i - 2] % 10007) % 10007;
        }
        System.out.println(dp[n]);
    }
}