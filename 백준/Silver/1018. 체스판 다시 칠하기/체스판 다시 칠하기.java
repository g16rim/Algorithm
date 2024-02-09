import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, result;
    static String[] board;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N];
        result = N * M;

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine();
        }

        for (int i = 0; i < N - 8 + 1; i++) {
            for (int j = 0; j < M - 8 + 1; j++) {
                count(i, j, 'W', 'B');
                count(i, j, 'B', 'W');
            }
        }

        System.out.println(result);

    }

    static void count(int x, int y, char ch1, char ch2) {

        int temp = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j += 2) {
                if (board[i].charAt(j) != ch1) temp++;
                if (board[i].charAt(j + 1) != ch2) temp++;
            }
            char ch3 = ch1;
            ch1 = ch2;
            ch2 = ch3;
        }

        result = Math.min(result, temp);

    }

}