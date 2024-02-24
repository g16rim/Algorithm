import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static List<Integer>[] contact = new ArrayList[100 + 1];
    static int[] result = new int[2]; // 노드 번호, 단계

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            listInit();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < L / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                contact[from].add(to);
            }

            call(S);
            sb.append("#").append(tc).append(" ").append(result[0]).append("\n");
        }
        System.out.print(sb);

    }

    static void call(int S) {
            Queue<int[]> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[101];

            queue.add(new int[] {S, 0});
            visited[S] = true;
            result[0] = S;
            result[1] = 0;

            while (!queue.isEmpty()) {
                int[] temp = queue.poll();

                for (int i = 0; i < contact[temp[0]].size(); i++) {
                    int newNode = contact[temp[0]].get(i);
                    if (visited[newNode] == true) continue;

                    queue.add(new int[] {newNode, temp[1] + 1});
                    visited[newNode] = true;
                    if (result[1] < temp[1] + 1) {
                        result[1] = temp[1] + 1;
                        result[0] = newNode;
                    } else if (result[1] == temp[1] + 1) {
                        result[0] = Math.max(result[0], newNode);
                    }
                }
            }
    }

    static void listInit() {
        for (int i = 1; i <= 100; i++) {
            contact[i] = new ArrayList<>();
        }
    }
}