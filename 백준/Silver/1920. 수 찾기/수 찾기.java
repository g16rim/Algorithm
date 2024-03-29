import java.io.*;
import java.util.*;

class Main {
    static int n;
    static long m, arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        m = Long.parseLong(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            long target = Long.parseLong(st.nextToken());
            int left = 0;
            int right = arr.length - 1;
            int result = 0;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] == target) {
                    result = 1;
                    break;
                } else if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}