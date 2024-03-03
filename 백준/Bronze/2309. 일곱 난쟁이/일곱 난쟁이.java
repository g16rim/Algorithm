import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int dwarfs[], sum;
    private static boolean visited[], flag;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dwarfs = new int[9];
        for (int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
            sum += dwarfs[i];
        }
        Arrays.sort(dwarfs);
        visited = new boolean[9];
        for (int i = 0; i < 8; i++) comb(0, i);
        System.out.print(sb);
    }

    private static void comb(int cnt, int idx) {
        if (flag) return;

        if (cnt == 2) {
            int temp = sum;
            for (int i = 0; i < 9; i++) {
                if (visited[i]) temp -= dwarfs[i];
            }
            if (temp == 100) {
//                System.out.println(Arrays.toString(visited));
                flag = true;
                for (int i = 0; i < 9; i++)
                    if (!visited[i]) {
                        sb.append(dwarfs[i]).append("\n");
                    }
            }
            return;
        }

        if (idx >= 9) return;

        visited[idx] = true;
        comb(cnt + 1, idx + 1);

        visited[idx] = false;
        comb(cnt, idx + 1);
    }
}