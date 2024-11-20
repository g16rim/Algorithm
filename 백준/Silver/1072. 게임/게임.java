import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = (int) ((long) y * 100 / x);
        
        int start = 1; // 추가로 이긴 게임 수
        int end = 1_000_000_000;
        int result = -1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            int nx = x + mid;
            int ny = y + mid;
            double nz = (int) ((long) ny * 100 / nx);
            
            if (z < nz) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        System.out.println(result);
    }
}
