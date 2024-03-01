import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    private static int[] dr = {0, -1, 0, 1, 0}, dc = {0, 0, 1, 0, -1};
    private static int M, A;
    private static int[] am, bm; // 이동 정보
    private static BC[] bcs;

    public static class BC {
        int x, y, c, p, selected;
        public BC(int x, int y, int c, int p) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
            this.selected = 0;
        }
        public boolean inRange(int x, int y) {
            return Math.abs(this.x - x) + Math.abs(this.y - y) <= this.c;
        }
    }

    private static int calculate(int ar, int ac, int br, int bc) {
        int max = 0;
        for (int i = 0; i < A; i++) {
            if (bcs[i].inRange(ar, ac)) {
                bcs[i].selected++;
            }
            for (int j = 0; j < A; j++) {
                if (bcs[j].inRange(br, bc)) {
                    bcs[j].selected++;
                }
                int temp = 0;
                for (int k = 0; k < A; k++) {
                    temp += (bcs[k].selected > 0 ? bcs[k].p / bcs[k].selected : 0);
//                    System.out.println(temp);
                }
                max = Math.max(max, temp);
                if (bcs[j].inRange(br, bc)) {
                    bcs[j].selected--;
                }
            }
            if (bcs[i].inRange(ar, ac)) {
                bcs[i].selected--;
            }
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(in.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            am = new int[M];
            bm = new int[M];
            bcs = new BC[A];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < M; i++) {
                am[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < M; i++) {
                bm[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(in.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                bcs[i] = new BC(x, y, c, p);
            }
//            System.out.println(Arrays.toString(am));
//            System.out.println(Arrays.toString(bm));
            int ar = 1, ac = 1, br = 10, bc = 10; // 초기 위치
            // 충전량 계산
            int sum = calculate(ar, ac, br, bc);
//            System.out.println(sum);
            for (int i = 0; i < M; i++) {
                ar += dr[am[i]];
                ac += dc[am[i]];
                br += dr[bm[i]];
                bc += dc[bm[i]];
                sum += calculate(ar, ac, br, bc);
            }
            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }
        System.out.print(sb);
    }

}