import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, D, result, maxResult;
    static int[][] originMap, tempMap;
    static int[] archers = new int[3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        originMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                originMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pickArchersPos(0, 0);
        System.out.println(maxResult);
    }

    static void pickArchersPos(int cnt, int start) {
        if (cnt == 3) {
            copyMap();
            attack();
            maxResult = Math.max(maxResult, result);
            return;
        }
        for (int i = start; i < M; i++) {
            archers[cnt] = i;
            pickArchersPos(cnt + 1, i + 1);
        }
    }

    static void attack() {
        result = 0;
        for (int line = N - 1; line >= 0; line--) {
            List<int []> attacked = new ArrayList<>();
            for (int a : archers) {
                int minDist = Integer.MAX_VALUE;
                int targetX = -1;
                int targetY = -1;
                for (int j = 0; j < M; j++) {
                    for (int i = line; i >= 0; i--) {
                        if (tempMap[i][j] == 0) continue;
                        int dist = calcDist(line + 1, a, i, j);
                        if (dist <= D) {
                            if (dist < minDist) {
                                minDist = dist;
                                targetX = i;
                                targetY = j;
                            } else if (dist == minDist && j < targetY) {
                                targetX = i;
                                targetY = j;
                            }
                        }
                    }
                }
                if (targetX != - 1 && targetY != -1) attacked.add(new int[]{targetX, targetY});
            }
            // 3명 모두 공격 끝
            for (int i = 0; i < attacked.size(); i++) {
                int[] temp = attacked.get(i);
                int x = temp[0];
                int y = temp[1];
                if (tempMap[x][y] == 1) {
                    result++;
                    tempMap[x][y] = 0;
                }
            }
            attacked.clear();
        }
    }

    static int calcDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static void copyMap() {
        tempMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = originMap[i][j];
            }
        }
    }

}