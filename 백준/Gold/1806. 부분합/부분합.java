import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, s, a[], len = 100001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        a = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        int i = 0, j = 0, sum = 0;
        while (j <= n) {
            if (sum < s) sum += a[j++];
            else if (sum >= s) {
                len = Math.min(len, j - i);
                sum -= a[i++];
            }
        }

        if (len == 100001) len = 0;
        System.out.println(len);
    }
}