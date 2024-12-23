import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 2; i <= 9; i++) {
            solve(1, i);
        }
        System.out.println(sb);
    }
    
    static void solve(int len, int num) {
        if (!isPrime(num)) return;
        
        if (len == n) {
            sb.append(num).append("\n");
            return;
        }
        
        for (int i = 1; i <= 9; i += 2) {
            solve(len + 1, num * 10 + i);
        }
    }
    
    static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
