import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] tri = new int[n][n + 1];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i + 1; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i + 1; j++) {
                tri[i][j] += Math.max(tri[i - 1][j - 1], tri[i - 1][j]);
            }
        }

        int result = 0;
        for (int j = 1; j <= n; j++) {
            result = Math.max(result, tri[n - 1][j]);
        }

        System.out.println(result);

    }

}