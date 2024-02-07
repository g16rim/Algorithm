import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, R;
    static int[][] A = new int[110][110];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            int comm = Integer.parseInt(st.nextToken());

            switch (comm) {
                case 1: // 성하 반전
                    A = fun1();
                    break;
                case 2: // 좌우 반전
                    A = fun2();
                    break;
                case 3: // 오른쪽으로 90도 회전
                    A = fun3();
                    break;
                case 4: // 왼쪽으로 90도 회전
                    A = fun4();
                    break;
                case 5:
                    A = fun5();
                    break;
                case 6:
                    A = fun6();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(A[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static int[][] fun1() {
        int[][] temp = new int[110][110];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = A[N - 1 - i][j];
            }
        }

        return temp;
    }

    static int[][] fun2() {
        int[][] temp = new int[110][110];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = A[i][M - 1 - j];
            }
        }

        return temp;
    }

    static int[][] fun3() {
        int[][] temp = new int[110][110];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = A[N - 1 - j][i];
            }
        }

        int L = M;
        M = N;
        N = L;

        return temp;
    }

    static int[][] fun4() {
        int[][] temp = new int[110][110];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = A[j][M - 1 - i];
            }
        }

        int L = M;
        M = N;
        N = L;

        return temp;
    }

    static int[][] fun5() {
        int[][] temp = new int[110][110];

        // 1번 그룹 -> 2번 그룹
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                temp[i][j + M / 2] = A[i][j];
            }
        }

        // 2번 그룹 -> 3번 그룹
        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                temp[i + N / 2][j] = A[i][j];
            }
        }

        // 3번 그룹 -> 4번 그룹
        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {
                temp[i][j - M / 2] = A[i][j];
            }
        }

        // 4번 그룹 -> 1번 그룹
        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                temp[i - N / 2][j] = A[i][j];
            }
        }

        return temp;
    }

    static int[][] fun6() {
        int[][] temp = new int[110][110];

        // 1번 그룹 -> 4번 그룹
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                temp[i + N / 2][j] = A[i][j];
            }
        }

        // 4번 그룹 -> 3번 그룹
        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                temp[i][j + M / 2] = A[i][j];
            }
        }

        // 3번 그룹 -> 2번 그룹
        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2 ; j < M; j++) {
                temp[i - N / 2][j] = A[i][j];
            }
        }

        // 2번 그룹 -> 1번 그룹
        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                temp[i][j - M / 2] = A[i][j];
            }
        }

        return temp;
    }

}