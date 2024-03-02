import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, arr[], permArr[];
    private static boolean visited[];
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        permArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        perm(0);
        System.out.print(sb);
    }

    private static void perm(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) sb.append(permArr[i]).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            permArr[cnt] = arr[i];
            perm(cnt + 1);
            visited[i] = false;
        }
    }
}