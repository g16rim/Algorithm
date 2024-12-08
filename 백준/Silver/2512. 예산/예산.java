import java.io.*;
import java.util.*;

public class Main {
    static int n, m, result;
    static int[] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        
        Arrays.sort(arr);
        
        int start = 0;
        int end = arr[n - 1];
        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            
            for (int i = 0; i < n; i++) {
                sum += Math.min(mid, arr[i]);
            }
            
            if (sum <= m) {
                result = Math.max(result, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        System.out.println(result);
    }
}
