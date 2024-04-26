import java.io.*;
import java.util.*;

public class Main {
    static int n, k, dp[], coin[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coin = new int[n];
        dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= k; j++) {
                if (coin[i] > j) continue;
                dp[j] += dp[j - coin[i]];
            }
        }

        System.out.println(dp[k]);
    }

}