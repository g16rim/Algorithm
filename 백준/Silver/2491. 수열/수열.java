import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int cnt1 = 1;
        int cnt2 = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] <= arr[i]) {
                cnt1++;
            } else {
                cnt1 = 1;
            }
            
            if (arr[i - 1] >= arr[i]) {
                cnt2++;
            } else {
                cnt2 = 1;
            }
            
            max = Math.max(max, Math.max(cnt1, cnt2));
        }
        
        System.out.println(max);
    }
}
