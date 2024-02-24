import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int[] parents;
    static Edge[] edgeList;

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static void make(int V) {
        parents = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }
    }

    static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            edgeList = new Edge[E];
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edgeList[i] = new Edge(start, end, weight);
            }

            make(V);
            Arrays.sort(edgeList);

            int count = 0;
            long result = 0;
            for (Edge edge : edgeList) {
                if (union(edge.start, edge.end)) {
                    result += edge.weight;
                    if (++count == V - 1) break;
                }
            }

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }

}