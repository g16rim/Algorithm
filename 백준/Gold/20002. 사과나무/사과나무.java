import java.io.*;
import java.util.*;

public class Main {
    private static int n, result = Integer.MIN_VALUE;
    private static int[][] arr, sum;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        sum = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + arr[i][j];
            }
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = k; i <= n; i++) {
                for (int j = k; j <= n; j++) {
                    result = Math.max(result, sum[i][j] - sum[i][j - k] - sum[i - k][j] + sum[i - k][j - k]);
                }
            }
        }
        
        System.out.println(result);
    }
}
