import java.io.*;
import java.util.*;

public class Main {
    static int[] cache = new int[1000];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int l1 = s1.length();
        int l2 = s2.length();

        int[][] dp = new int[l1 + 1][l2 + 1];
        
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(dp[l1][l2]).append("\n");
        
        List<Character> list = new ArrayList<>();
        
        while (l1 > 0 && l2 > 0) {
            if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
                list.add(s1.charAt(l1 - 1));
                l1--;
                l2--;
            } else if (dp[l1 - 1][l2] > dp[l1][l2 - 1]) {
                l1--;
            } else {
                l2--;
            }
        }
        
        for (int k = list.size() - 1; k >= 0; k--) {
            sb.append(list.get(k));
        }
        
        System.out.println(sb);
    }
}