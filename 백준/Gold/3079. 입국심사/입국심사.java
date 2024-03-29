import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static long arr[], max, result = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
        max = arr[arr.length - 1];

        long left = 0L;
        long right = (long) m * max;
        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0; // 시간 내에 처리할 수 있는 사람 수
            for (int i = 0; i < n; i++) {
                cnt += (mid / arr[i]);
                if (cnt >= m) break;
            }

            if (cnt >= m) {
                result = Math.min(result, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }
}