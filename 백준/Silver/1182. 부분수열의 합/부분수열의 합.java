import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, S, arr[], result;
    private static boolean visited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        powerset(0, 0);
        System.out.println(result);
    }

    private static void powerset(int idx, int sum) {
        if (idx == N && sum == S) {
            for (int i = 0; i < N; i++) { // 공집합 빼기
                if (visited[i]) {
                    result++;
                    return;
                }
            }
            return;
        }
        if (idx == N) return;

        visited[idx] = true;
        powerset(idx + 1, sum + arr[idx]);

        visited[idx] = false;
        powerset(idx + 1, sum);
    }
}