import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long[][] dp = new long[n + 1][4];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i >= j) {
                    for (int l = 0; l <= 3; l++) {
                        dp[i][j] += dp[i - j][l];
                    }
                }
            }
        }

        if (dp[n][1] + dp[n][2] + dp[n][3] < k) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            for (int i = 1; i <= 3; i++) {
                if (n >= i) {
                    if (dp[n][i] >= k) {
                        if (sb.length() > 0) {
                            sb.append("+");
                        }
                        sb.append(i);
                        n -= i;
                        break;
                    } else {
                        k -= dp[n][i];
                    }
                }
            }
        }
        System.out.println(sb);
    }
}