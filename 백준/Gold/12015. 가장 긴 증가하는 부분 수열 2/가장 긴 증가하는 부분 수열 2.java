import java.io.*;
import java.util.*;

class Main {
    static int n, arr[], lis[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        lis = new int[n];
        lis[0] = arr[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
//            System.out.println(Arrays.toString(lis));
            if (lis[len - 1] < arr[i]) {
                lis[len++] = arr[i];
            } else {
                int pos = binarySearch(0, len, arr[i]); // 현재까지의 lis에서 들어갈 자리 이분탐색으로 찾기
                lis[pos] = arr[i];
            }
        }
        System.out.println(len);
    }

    static int binarySearch(int start, int end, int val) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (lis[mid] < val) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}