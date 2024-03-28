import java.io.*;
import java.util.*;

class Main {
    static List<Position> stores = new ArrayList<>();
    static Position start, end;
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();

    static class Position {
        int x, y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getDistance(Position p) {
            return Math.abs(this.x - p.x) + Math.abs(this.y - p.y);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            visited = new boolean[n];
            stores.clear();
            
            st = new StringTokenizer(br.readLine());
            start = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                stores.add(new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            st = new StringTokenizer(br.readLine());
            end = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            bfs();
        }
        System.out.print(sb);
    }

    static void bfs() {
        Queue<Position> q = new ArrayDeque<>();
        q.add(start);

        while (!q.isEmpty()) {
            Position temp = q.poll();

            if (temp.getDistance(end) <= 1000) {
                sb.append("happy\n");
                return;
            }

            for (int i = 0; i < stores.size(); i++) {
                if (!visited[i] && stores.get(i).getDistance(temp) <= 1000) {
                    q.add(stores.get(i));
                    visited[i] = true;
                }
            }
        }
        sb.append("sad\n");
    }
}