import java.util.*;

class Solution {
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        // dfs(numbers, target, 0, 0);
        bfs(numbers, target);
        return answer;
    }
    
    void bfs(int[] numbers, int target) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {numbers[0], 0});
        q.add(new int[] {-numbers[0], 0});
        
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int sum = temp[0];
            int idx = temp[1];
            
            if (idx == numbers.length - 1) {
                if (target == sum) {
                    answer++;
                }
                continue;
            }
            
            q.add(new int[] {sum + numbers[idx + 1], idx + 1});
            q.add(new int[] {sum - numbers[idx + 1], idx + 1});
        }
    }
    
    private void dfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            if (sum == target) answer++;
            return;
        }
        
        dfs(numbers, target, index + 1, sum + numbers[index]);
        dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}