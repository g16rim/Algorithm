import java.io.*;
import java.util.*;

public class Main {
    static long[] homes;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        homes = new long[n];
        for (int i = 0; i < n; i++) {
            homes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(homes);
        
        long low = 1;
        long high = homes[n - 1] - homes[0];
        while (low <= high) {
            long mid = (low + high) / 2;
            
            if (count(mid) < c) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        System.out.println(low - 1);
    }
    
    static int count(long distance) {
        int result = 1;
        long last = homes[0];
        
        for (int i = 1; i < homes.length; i++) {
            long locate = homes[i];
            
            if (locate - last >= distance) {
                result++;
                last = locate;
            }
        }
        return result;
    }
}
