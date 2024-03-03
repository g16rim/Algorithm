import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int N, alp[];
    private static String input[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        input = new String[N];
        for (int i = 0; i < N; i++) input[i] = br.readLine();

        alp = new int[26];

        for (int i = 0; i < N; i++) {
            int len = input[i].length();
            for (int j = 0; j < len; j++) {
                int idx = input[i].charAt(j) - 'A';
                alp[idx] += (int) Math.pow(10, len - 1 - j);
            }
        }

        Arrays.sort(alp);

        int sum = 0, value = 9;
        for (int i = 25; i >= 0; i--) {
            sum += (value-- * alp[i]);
        }
        System.out.println(sum);
    }
}