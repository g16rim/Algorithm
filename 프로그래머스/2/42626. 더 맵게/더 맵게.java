import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        Arrays.sort(scoville);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        while (pq.size () > 1) {
            int first = pq.poll();
            if (first >= K) break;
            int second = pq.poll();
            pq.add(first + 2 * second);
            answer++;
        }
        
        if (pq.peek() < K) answer = -1;
        return answer;
    }
}