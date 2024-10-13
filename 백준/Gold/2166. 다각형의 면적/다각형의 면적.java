import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] points = new long[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Long.parseLong(st.nextToken());
            points[i][1] = Long.parseLong(st.nextToken());
        }
        
        long a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            a += (points[i][0] * points[(i + 1) % n][1]);
            b += (points[i][1] * points[(i + 1) % n][0]);
        }
        
        double result = Math.abs(a - b) / 2.0;
        System.out.printf("%.1f\n", result);
    }
}
