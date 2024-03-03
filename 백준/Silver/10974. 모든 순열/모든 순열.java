import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static int N, arr[];
    public static boolean visited[];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N + 1];
        perm(0);
        System.out.print(sb);
    }

    public static void perm(int cnt) {
        if (cnt == N) {
            for (int i = 0; i < N; i++) sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            arr[cnt] = i;
            visited[i] = true;
            perm(cnt + 1);
            visited[i] = false;
        }
    }
}