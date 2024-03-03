import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] liquid = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) liquid[i] = Integer.parseInt(st.nextToken());

        int result = Integer.MAX_VALUE;
        int x = 0, y = 0;
        int i = 0, j = n - 1;
        while (i < j) {
            int diff = liquid[i] + liquid[j];
            if (Math.abs(diff) < result) {
                x = liquid[i]; y = liquid[j];
                result = Math.abs(diff);
                if (result == 0) break;
            }
            if (diff < 0) i++;
            else if (diff > 0) j--;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(x).append(" ").append(y);
        System.out.println(sb);
    }
}