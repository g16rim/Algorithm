import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (a,b) -> a[1] - b[1]);
        
        int pos = routes[0][1];
        for (int i = 1; i < routes.length; i++) {
            if (pos < routes[i][0]) {
                answer++;
                pos = routes[i][1];
            }
        }
        // System.out.println(Arrays.deepToString(routes));
        return answer;
    }
}