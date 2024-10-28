import java.io.*;
import java.util.*;

public class Main {
    private static int[][] sum;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());
        
        int n = s.length();
        sum = new int[n + 1][26];

        for (int i = 1; i <= n; i++) {
            int c = s.charAt(i - 1) - 'a';
            
            for (int j = 0; j < 26; j++) {
                sum[i][j] = sum[i - 1][j];
            }
            
            sum[i][c]++;
        }
        
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int a = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            
            sb.append(sum[r + 1][a] - sum[l][a]).append("\n");
        }
        
        System.out.println(sb);
    }
}
