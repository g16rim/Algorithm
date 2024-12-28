import java.io.*;
import java.util.*;

public class Main {
    static int n, m, result = Integer.MAX_VALUE, temp;
    static int[][] arr;
    static List<int[]> chicken = new ArrayList<>();
    static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        
        int homeCnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) chicken.add(new int[] {i, j});
            }
        }
        
        visited = new boolean[chicken.size()];
        comb(0, 0);
        System.out.println(result);
    }
    
    static void comb(int idx, int cnt) {
        if (cnt == m) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 1) calcDist(i, j);
                }
            }
            result = Math.min(result, temp);
            temp = 0;
            return;
        }
        
        if (idx >= chicken.size()) return;
        
        visited[idx] = true;
        comb(idx + 1, cnt + 1);
        
        visited[idx] = false;
        comb(idx + 1, cnt);
    }
    
    static void calcDist(int x, int y) {
        int dist = Integer.MAX_VALUE;
        for (int i = 0; i < chicken.size(); i++) {
            if (!visited[i]) continue;
            dist = Math.min(dist, getDistance(x, y, chicken.get(i)[0], chicken.get(i)[1]));
        }
        temp += dist;
    }
    
    static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
