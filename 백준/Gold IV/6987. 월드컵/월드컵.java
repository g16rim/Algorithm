import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] scores = new int[6][3];
    static boolean flag;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 4; tc++) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 6; i++) {
                scores[i][0] = Integer.parseInt(st.nextToken());
                scores[i][1] = Integer.parseInt(st.nextToken());
                scores[i][2] = Integer.parseInt(st.nextToken());
            }

            flag = false;
            match(0, 1);

            if (flag) sb.append("1 ");
            else sb.append("0 ");
        }

        System.out.println(sb);

    }

    static void match(int home, int away) {
        if (flag) return;

        if (home == 5) {
            if (isGame()) flag = true;
            return;
        }

        if (away == 6) {
            match(home + 1, home + 2);
            return;
        }

        if (scores[home][0] > 0 && scores[away][2] > 0) {
            scores[home][0]--;
            scores[away][2]--;
            match(home, away + 1);
            scores[home][0]++;
            scores[away][2]++;
        }

        if (scores[home][1] > 0 && scores[away][1] > 0) {
            scores[home][1]--;
            scores[away][1]--;
            match(home, away + 1);
            scores[home][1]++;
            scores[away][1]++;
        }

        if (scores[home][2] > 0 && scores[away][0] > 0) {
            scores[home][2]--;
            scores[away][0]--;
            match(home, away + 1);
            scores[home][2]++;
            scores[away][0]++;
        }
    }

    static boolean isGame() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (scores[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}