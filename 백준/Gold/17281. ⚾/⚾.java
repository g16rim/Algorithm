import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, inning, batBox, outCnt, score, result = Integer.MIN_VALUE;
    static int[][] attack;
    static int[] order;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        attack = new int[N][9];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                attack[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        order = new int[9];
        order[3] = 0;
        visited = new boolean[9];
        visited[0] = true;
        perm(0);
        System.out.println(result);
    }

    static void perm(int cnt) {
        if (cnt == 9) {
//            System.out.println(Arrays.toString(order));
            playBall();
            return;
        }

        for (int i = 1; i < 9; i++) {
            if (visited[i] == true) continue;
            if (cnt == 3) cnt++; // 4번 타순 넘보지 마!
            order[cnt] = i;
            visited[i] = true;
            perm(cnt + 1);
            visited[i] = false;
        }
    }

    static void playBall() {
        score = 0;
        inning = 0;
        batBox = 0;
        int hit = 0;
        boolean[] base = new boolean[3];
        while (inning < N) {
            hit = attack[inning][order[batBox]];
            batBox = (batBox + 1) % 9;
            switch (hit) {
                case 0:
                    outCnt++;
                    break;
                case 1: // 0->1, 1->2, 2->3, 3 득점
                    singleHit(base);
                    break;
                case 2: // 0->2, 1->3, 2, 3 득점
                    doubleHit(base);
                    break;
                case 3: // 0->3, 1, 2, 3 득점
                    tripleHit(base);
                    break;
                case 4: // 0, 1, 2, 3 득점
                    homerun(base);
            }

            if (outCnt == 3) {
                inning++;
                outCnt = 0;
                base = new boolean[3];
            }
        }
        result = Math.max(result, score);
    }

    static void singleHit(boolean[] base) {
        if (base[2] == true) score++;
        base[2] = base[1];
        base[1] = base[0];
        base[0] = true;
    }

    static void doubleHit(boolean[] base) {
        if (base[2] == true) score++;
        if (base[1] == true) score++;
        base[2] = base[0];
        base[1] = true;
        base[0] = false;
    }

    static void tripleHit(boolean[] base) {
        if (base[2] == true) score++;
        if (base[1] == true) score++;
        if (base[0] == true) score++;
        base[2] = true;
        base[1] = false;
        base[0] = false;
    }

    static void homerun(boolean[] base) {
        for (int i = 0; i < 3; i++) {
            if (base[i] == true) score++;
            base[i] = false;
        }
        score++;
    }
}