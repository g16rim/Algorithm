import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] sour, bitter;
    static long sourSum, bitterSum, result = 1_000_000_001;
    static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sour = new int[n];
        bitter = new int[n];
        visited = new boolean[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }
        
        subSet(0, 0);
        System.out.println(result);
    }
    
    static void subSet(int idx, int cnt) {
        if (idx == n) {
            if (cnt > 0) {
                sourSum = 1;
                bitterSum = 0;
                for (int i = 0; i < n; i++) {
                    if (visited[i]) {
                        sourSum *= sour[i];
                        bitterSum += bitter[i];
                    }
                }
                result = Math.min(result, Math.abs(sourSum - bitterSum));
            }            
            return;
        }
        
        visited[idx] = true;
        subSet(idx + 1, cnt + 1);
        visited[idx] = false;
        subSet(idx + 1, cnt);
    }
}
