import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static long[][] x;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        x = new long[n][2];
        
        long total = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i][0] = Integer.parseInt(st.nextToken());
            x[i][1] = Integer.parseInt(st.nextToken());
            total += x[i][1];
        }
        
        Arrays.sort(x, (a, b) -> Long.compare(a[0], b[0]));
        
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += x[i][1];
            if (cnt >= (total + 1) / 2) {
                System.out.println(x[i][0]);
                return;
            }
        }
    }
}
