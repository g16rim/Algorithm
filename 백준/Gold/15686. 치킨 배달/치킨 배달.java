import java.io.*;
import java.util.*;

public class Main {
    static int n, m, result = Integer.MAX_VALUE;
    static List<int[]> homes = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static boolean[] selected;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) homes.add(new int[]{i, j}); // 집
                if (value == 2) chickens.add(new int[]{i, j}); // 치킨집
            }
        }

        selected = new boolean[chickens.size()];
        comb(0, 0);
        System.out.println(result);
    }

    static void comb(int idx, int cnt) {
        if (cnt == m) {
            result = Math.min(result, calcTotalDistance());
            return;
        }
        if (idx >= chickens.size()) return;

        // 현재 치킨집 선택
        selected[idx] = true;
        comb(idx + 1, cnt + 1);

        // 현재 치킨집 선택하지 않음
        selected[idx] = false;
        comb(idx + 1, cnt);
    }

    static int calcTotalDistance() {
        int totalDistance = 0;

        for (int[] home : homes) {
            int minDistance = Integer.MAX_VALUE;
            for (int i = 0; i < chickens.size(); i++) {
                if (selected[i]) {
                    int[] chicken = chickens.get(i);
                    minDistance = Math.min(minDistance, Math.abs(home[0] - chicken[0]) + Math.abs(home[1] - chicken[1]));
                }
            }
            totalDistance += minDistance;
        }

        return totalDistance;
    }
}
