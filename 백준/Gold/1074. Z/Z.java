import java.io.*;
import java.util.*;

public class Main {
    static int n, r, c, result;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        int size = (int) Math.pow(2, n);
        solve(size, 0, 0);
        
        System.out.println(result);
    }
    
    static void solve(int size, int x, int y) {
        if (size == 2) {
            if (x == r && y + 1 == c) result += 1;
            else if (x + 1 == r && y == c) result += 2;
            else if (x + 1 == r && y + 1 == c) result += 3;
            return;
        }
        
        int ns = size / 2;
        
        if (r < x + ns && c < y + ns) {
            solve(ns, x, y);
        } else if (r < x + ns && c < y + size) {
            result += ns * ns;
            solve(ns, x, y + ns);
        } else if (r < x + size && c < y + ns) {
            result += ns * ns * 2;
            solve(ns, x + ns, y);
        } else if (r < x + size && c < y + size) {
            result += ns * ns * 3;
            solve(ns, x + ns, y + ns);
        }
    }
}
