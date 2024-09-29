import java.io.*;
import java.util.*;

public class Main {
    static int n, map[][];
    static long dp[][][];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new long[n][n][3];
        
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][1][0] = 1L; // 초기 상태: 가로
        
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (map[i][j] == 1) continue;
                
                // 가로
                dp[i][j][0] += dp[i][j - 1][0]; // 가로 -> 가로
                dp[i][j][0] += dp[i][j - 1][2]; // 대각선 -> 가로
                
                if (i >= 1) { // 세로
                    dp[i][j][1] += dp[i - 1][j][1]; // 세로 -> 세로
                    dp[i][j][1] += dp[i - 1][j][2]; // 대각선 -> 세로
                }
                
                if (i >= 1 && map[i][j - 1] == 0 && map[i - 1][j] == 0 && map[i - 1][j - 1] == 0) { // 대각선
                    dp[i][j][2] += dp[i - 1][j - 1][0]; // 가로 -> 대각선
                    dp[i][j][2] += dp[i - 1][j - 1][1]; // 세로 -> 대각선
                    dp[i][j][2] += dp[i - 1][j - 1][2]; // 대각선 -> 대각선
                }
            }
        }
        
        System.out.println(dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2]);
    }
}
