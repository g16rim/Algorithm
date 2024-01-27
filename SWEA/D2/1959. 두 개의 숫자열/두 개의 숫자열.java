import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int[] a; // 더 짧은 배열
    static int[] b; // 더 긴 배열
 
    public static void main(String[] args) throws NumberFormatException, IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            int result = -1_000_000_000;
            st = new StringTokenizer(br.readLine());
 
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
 
            // TODO N == M 처리
            if (N < M) {
                a = new int[N];
                b = new int[M];
                 
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < N; i++) {
                    a[i] = Integer.parseInt(st.nextToken());
                }
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < M; i++) {
                    b[i] = Integer.parseInt(st.nextToken());
                }
            } else if (N > M) {
                a = new int[M];
                b = new int[N];
                 
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < N; i++) {
                    b[i] = Integer.parseInt(st.nextToken());
                }
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < M; i++) {
                    a[i] = Integer.parseInt(st.nextToken());
                }
            }
 
            for (int i = 0; i < b.length - a.length + 1; i++) {
                int temp = 0;
                for (int j = 0; j < a.length; j++) {
                    temp += (b[i + j] * a[j]);
                }
                if (temp > result)
                    result = temp;
            }
             
            sb.append("#").append(tc).append(" ").append(result);
            System.out.println(sb);
        }
 
    }
 
}