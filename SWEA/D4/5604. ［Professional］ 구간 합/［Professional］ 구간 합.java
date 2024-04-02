import java.io.*;
import java.util.*;

class Solution {
    static long start, end, a[], result, tmp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            start = Long.parseLong(st.nextToken());
            end = Long.parseLong(st.nextToken());

            a = new long[10];
            result = 0;
            tmp = 1;
            if (start == 0)
                start = 1;
            while (start <= end) {
                while (start % 10 != 0 && start <= end) {
                    f(start);
                    start++;
                }
                if (start > end) break;
                while (end % 10 != 9 && start <= end) {
                    f(end);
                    end--;
                }
                long diff = end / 10 - start / 10 + 1;
                for (int i = 0; i < 10; i++)
                    a[i] += diff * tmp;
                tmp *= 10;
                start /= 10;
                end /= 10;
            }
            for (int i = 1; i < 10; i++)
                result += (i * a[i]);
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }

    static void f(long x) {
        for (long i = x; i > 0; i /= 10) {
            String s = String.valueOf(i);
            int n = s.charAt(s.length() - 1) - '0';
            a[n] += tmp;
        }
    }
}