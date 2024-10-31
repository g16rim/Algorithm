import java.util.*;

class Solution {
    boolean[] visited;
    String temp = "";
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        dfs("ICN", "ICN", tickets, 0);
        
        answer = temp.split(" ");
        
        return answer;
    }
    
    void dfs(String start, String route, String[][] tickets, int cnt) {
        if (cnt == tickets.length) {
            if (temp.isEmpty() || route.compareTo(temp) < 0) {
                temp = route;
            }
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (start.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt + 1);
                visited[i] = false;
            }
        }
    }
}