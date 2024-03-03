import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static int n, result = Integer.MIN_VALUE;
    private static char exp[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        exp = new char[n];
        exp = br.readLine().toCharArray();

        recur(2, exp[0] - '0');
        System.out.println(result);
    }

    private static void recur(int idx, int sum) {
        if (idx >= n) {
            result = Math.max(result, sum);
            return;
        }
        // 괄호 x
        recur(idx + 2, calc(sum, exp[idx - 1], exp[idx] - '0'));
        // 괄호 o
        if (idx + 2 < n) {
            int now = calc(exp[idx] - '0', exp[idx + 1], exp[idx + 2] - '0');
            recur(idx + 4, calc(sum, exp[idx - 1], now));
        }
    }

    private static int calc(int a, char op, int b) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }
        return -1;
    }
}