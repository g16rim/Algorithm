import java.io.*;
import java.util.*;

public class Main {
    private static int n, w, L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }
        int time = 0;
        int weight = 0;
        while (true) {
            time++;
            if (q.isEmpty() && bridge.isEmpty()) break;

            int temp = bridge.poll();
            weight -= temp;

            if (!q.isEmpty() && weight + q.peek() <= L) {
                bridge.add(q.peek());
                weight += q.poll();
            } else {
                bridge.add(0);
            }

            if (q.isEmpty() && !bridge.isEmpty()) { // 마지막 차량 건너기
                bridge.poll();
            }
        }

        System.out.println(time);
    }
}