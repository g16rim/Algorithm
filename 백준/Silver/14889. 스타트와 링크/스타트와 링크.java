import java.io.*;
import java.util.*;

public class Main {
    private static int[][] arr;
    private static int n, result = Integer.MAX_VALUE;
    private static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n];
        pick(0, 0);
        System.out.println(result);
    }
    
    private static void pick(int idx, int cnt) {
        if (cnt == n / 2) {
            int start = 0, link = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (visited[i] && visited[j]) {
                        start += arr[i][j] + arr[j][i];
                    } else if (!visited[i] && !visited[j]) {
                        link += arr[i][j] + arr[j][i];
                    }
                }
            }
            result = Math.min(result, Math.abs(start - link));
            return;
        }
        
        for (int i = idx; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            pick(i + 1, cnt + 1);
            visited[i] = false;
        }
    }
}
