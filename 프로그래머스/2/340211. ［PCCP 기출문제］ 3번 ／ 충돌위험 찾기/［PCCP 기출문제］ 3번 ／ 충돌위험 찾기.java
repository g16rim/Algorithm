import java.util.*;

class Solution {
    int n, answer = 0;
    Queue<int[]>[] q;
    
    public int solution(int[][] points, int[][] routes) {
        n = routes.length;
        q = new ArrayDeque[n];
        for (int i = 0; i < n; i++) q[i] = new ArrayDeque<int[]>();
        move(points, routes);
        checkCollision();
        return answer;
    }
    
    void checkCollision() {
        int[][] map;
        int count = 0;
        
        while (count != n) {
            map = new int[101][101];
            count = 0;
            for (int i = 0; i < n; i++) {
                if (q[i].isEmpty()) {
                    count++;
                    continue;
                }

                int[] temp = q[i].poll();
                map[temp[0]][temp[1]]++;
            }

            for (int i = 0; i < 101; i++) {
                for (int j = 0; j < 101; j++) {
                    if (map[i][j] > 1) 
                        answer++;
                }
            }
        }
    }
    
    void move(int[][] points, int[][] routes) {
        for (int i = 0; i < n; i++) {
            int[] cur = points[routes[i][0] - 1]; // 시작 위치
            int r = cur[0];
            int c = cur[1];
            q[i].add(new int[] {r, c});
            
            for (int j = 1; j < routes[0].length; j++) {
                int[] end = points[routes[i][j] - 1];
                int er = end[0];
                int ec = end[1];
                
                int dr = er - r;
                int dc = ec - c;
                
                while (dr != 0) {
                    if (dr > 0) {
                        dr--;
                        r++;
                    } else {
                        dr++;
                        r--;
                    }
                    q[i].add(new int[] {r, c});
                }
                while (dc != 0) {
                    if (dc > 0) {
                        dc--;
                        c++;
                    } else {
                        dc++;
                        c--;
                    }
                    q[i].add(new int[] {r, c});
                }
            }
        }
    }
}