import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[1000001];
        arr[1] = 1;
        if (n > 0) {
            for (int i = 2; i <= n; i++) {
                arr[i] = (arr[i - 1] % 1000000000 + arr[i - 2] % 1000000000) % 1000000000;
            }
        } else if (n < 0) {
            int abs = Math.abs(n);
            for (int i = 2; i <= abs; i++) {
                arr[i] = (arr[i - 2] % 1000000000 - arr[i - 1] % 1000000000) % 1000000000;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        long result = arr[Math.abs(n)];
        if (result > 0) {
            sb.append("1\n");
        } else if (result < 0) {
            sb.append("-1\n");
        } else {
            sb.append("0\n");
        }
        sb.append(Math.abs(result));
        System.out.println(sb);
    }
}
