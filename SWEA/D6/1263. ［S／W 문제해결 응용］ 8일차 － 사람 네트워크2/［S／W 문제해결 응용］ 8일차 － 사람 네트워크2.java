import java.io.*;
import java.util.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    static int n, dist[][], result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if (i == j) continue;
                    if (temp == 0) dist[i][j] = 100000;
                    else dist[i][j] = 1;
                }
            }
            floydWarshall();
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }

    static void floydWarshall() {
        result = 100000;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += dist[i][j];
            }
            result = Math.min(result, sum);
        }
    }
}