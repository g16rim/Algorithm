import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, result = Integer.MAX_VALUE;
    static int[] people; // 인구 수 배열
    static int[][] graph;
    static boolean[] visited; // 방문 배열
    static List<Integer> red, blue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        people = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        graph = new int[N + 1][];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            graph[i] = new int[size];
            int j = 0;
            while (st.hasMoreTokens()) {
                int node = Integer.parseInt(st.nextToken());
                graph[i][j++] = node;
            }
        }
        for (int i = 1; i <= N / 2; i++) {
            visited = new boolean[N + 1];
            comb(0, 0, i);
        }
        if (result == Integer.MAX_VALUE) result = -1;
        System.out.println(result);
    }

    static void comb(int start, int cnt, int maxCnt) {
        if (cnt == maxCnt) {
            // visited == true -> red, false -> blue
            divideRedAndBlue();

//            System.out.println("red " + red.toString());
//            System.out.println("blue " + blue.toString());

            if (!redBfs() || !blueBfs()) return;
            calcPeopleCount();
            return;
        }

        for (int i = start + 1; i <= N; i++) {
            visited[i] = true;
            comb(i, cnt + 1, maxCnt);
            visited[i] = false;
            comb(i, cnt, maxCnt);
        }
    }

    static void calcPeopleCount() {
        int redCount = 0;
        for (int i = 0; i < red.size(); i++) {
            redCount += people[red.get(i)];
        }
        int blueCount = 0;
        for (int i = 0; i < blue.size(); i++) {
            blueCount += people[blue.get(i)];
        }
        result = Math.min(result, Math.abs(redCount - blueCount));
    }

    static void divideRedAndBlue() {
        red = new ArrayList<>();
        blue = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (visited[i] == true) {
                red.add(i);
            } else {
                blue.add(i);
            }
        }
    }

    static boolean redBfs() {
        boolean[] redRegion = new boolean[N + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(red.get(0));
        redRegion[red.get(0)] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
//            if (graph[node].length == 0) return false;

            for (int i = 0; i < graph[node].length; i++) {
                int newNode = graph[node][i];
                if (redRegion[newNode] == true) {
                    continue;
                }
                if (visited[newNode] == true) {
                    redRegion[newNode] = true;
                    queue.add(newNode);
                }
            }
        }
        return Arrays.equals(visited, redRegion);
    }

    static boolean blueBfs() {
        boolean[] blueRegion = new boolean[N + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(blue.get(0));
        blueRegion[blue.get(0)] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
//            if (graph[node].length == 0) return false;

            for (int i = 0; i < graph[node].length; i++) {
                int newNode = graph[node][i];
                if (blueRegion[newNode] == true) {
                    continue;
                }
                if (visited[newNode] == false) {
                    blueRegion[newNode] = true;
                    queue.add(newNode);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (visited[i] == blueRegion[i]) return false;
        }
        return true;
    }

}