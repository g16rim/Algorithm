import java.util.*;

class Solution {
    int[] parents;
    
    void make(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = i;
    }

    int find(int i) {
        if (parents[i] == i) return parents[i];
        return parents[i] = find(parents[i]);
    }
    
    boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;
        
        parents[bRoot] = aRoot;
        return true;
    }
    
    class Edge implements Comparable<Edge> {
        int from, to, weight;
        
        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;      
        make(n);
        Edge[] edges = new Edge[costs.length];
        for (int i = 0; i < costs.length; i++) {
            edges[i] = new Edge(costs[i][0], costs[i][1], costs[i][2]);
        }
        
        Arrays.sort(edges);
        int count = 0;
        for (Edge e : edges) {
            if (union(e.from, e.to)) {
                answer += e.weight;
                count++;
            }
            
            if (count == n - 1) break;
        }
        
        return answer;
    }
}