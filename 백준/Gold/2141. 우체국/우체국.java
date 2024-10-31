import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long[][] arr = new long[n][2];
        long sum = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            sum += arr[i][1];
        }
        
        Arrays.sort(arr, (a, b) -> Long.compare(a[0], b[0]));
        
        long temp = 0;
        for (int i = 0; i < n; i++) {
            temp += arr[i][1];
            if (temp >= (sum + 1) / 2) {
                System.out.println(arr[i][0]);
                return;
            }
        }
    }
}
