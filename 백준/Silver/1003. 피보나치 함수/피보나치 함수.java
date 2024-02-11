import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] zero = new int[41];
    static int[] one = new int[41];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        zero[0] = 1;
        one[1] = 1;


        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            for (int i = 2; i <= N; i++) {
                zero[i] = zero[i - 2] + zero[i - 1];
                one[i] = one[i - 2] + one[i - 1];
            }

            sb.append(zero[N]).append(" ").append(one[N]).append("\n");
        }

        System.out.println(sb);

    }

}