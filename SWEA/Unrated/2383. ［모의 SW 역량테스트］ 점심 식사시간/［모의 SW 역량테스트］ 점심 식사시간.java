import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static int N, map[][], result;
    public static Queue<Position> s0, s1;
    public static List<Position> people, stairs;
    public static Position[] arr0, arr1;
    public static boolean[] visited;

    public static class Position implements Comparable<Position> {
        int r, c, time, distance;

        public Position(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }

        public void setDistance(Position p) {
            this.distance =  Math.abs(this.r - p.r) + Math.abs(this.c - p.c);
        }

        @Override
        public int compareTo(Position o) {
            return Integer.compare(this.distance, o.distance);
        }

        @Override
        public String toString() {
            return r + " " + c + " " + time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            // 변수 초기화
            N = Integer.parseInt(br.readLine());
            result = Integer.MAX_VALUE;
            people = new ArrayList<>();
            stairs = new ArrayList<>();
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) people.add(new Position(i, j, 0));
                    else if (map[i][j] > 1) stairs.add(new Position(i, j, map[i][j]));
                }
            }

            visited = new boolean[people.size()];
            // 0번 계단 - 사람 매칭
            powerset(0, 0);

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }

    public static void powerset(int cnt, int size) {
        if (cnt == people.size()) {
//            if (size == 3) System.out.println(Arrays.toString(visited));
            arr0 = new Position[size];
            arr1 = new Position[people.size() - size];
            int i0 = 0, i1 = 0;
            for (int i = 0; i < people.size(); i++) {
                if (visited[i]) arr0[i0++] = people.get(i);
                else arr1[i1++] = people.get(i);
            }
//            System.out.println(Arrays.toString(arr0));
//            System.out.println(Arrays.toString(arr1));

            // 1. 0번째 계단이랑 거리 다 계산
            for (int i = 0; i < arr0.length; i++) arr0[i].setDistance(stairs.get(0));
            // 2. 거리 가까운 순대로 정렬
            Collections.sort(Arrays.asList(arr0));
            s0 = new ArrayDeque<>();
            for (int i = 0; i < arr0.length; i++) {
                if (s0.size() < 3) {
                    arr0[i].time = arr0[i].distance + 1; // 대기 시간
                    s0.add(arr0[i]);
                }
                else if (s0.size() == 3) {
                    Position first = s0.poll();
                    // 원래 대기 시간 vs 첫 번째 사람이 완전 끝나기까지 걸리는 시간
                    arr0[i].time = Math.max(arr0[i].distance + 1, first.time + stairs.get(0).time);
                    s0.add(arr0[i]);
                }
//                System.out.println(s0.toString());
            }
            // 1. 0번째 계단이랑 거리 다 계산
            for (int i = 0; i < arr1.length; i++) arr1[i].setDistance(stairs.get(1));
            // 2. 거리 가까운 순대로 정렬
            Collections.sort(Arrays.asList(arr1));
            s1 = new ArrayDeque<>();
            for (int i = 0; i < arr1.length; i++) {
                if (s1.size() < 3) {
                    arr1[i].time = arr1[i].distance + 1;
                    s1.add(arr1[i]);
                }
                else if (s1.size() == 3) {
                    Position first = s1.poll();
                    arr1[i].time = Math.max(arr1[i].distance + 1, first.time + stairs.get(1).time);
                    s1.add(arr1[i]);
                }
            }
            int end = 0;
            while (!s0.isEmpty()) end = Math.max(end, s0.poll().time + stairs.get(0).time);
            while (!s1.isEmpty()) end = Math.max(end, s1.poll().time + stairs.get(1).time);
            result = Math.min(end, result);
            return;
        }

        visited[cnt] = true;
        powerset(cnt + 1, size + 1);
        visited[cnt] = false;
        powerset(cnt + 1, size);
    }
}