import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Set<String> s1 = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < a; i++) {
                s1.add(st.nextToken());
            }
            Set<String> s2 = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < b; i++) {
                s2.add(st.nextToken());
            }
            s1.retainAll(s2);
            sb.append("#").append(tc).append(" ").append(s1.size()).append("\n");
        }
        System.out.print(sb);
    }
}