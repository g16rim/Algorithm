import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pqR = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;
        
        for (String operation : operations) {
            st = new StringTokenizer(operation);
            
            String command = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if ("I".equals(command)) {
                pq.add(num);
                pqR.add(num);
            } else if ("D".equals(command) && !pq.isEmpty()) {
                if (num == -1) {
                    int temp = pq.poll();
                    pqR.remove(temp);
                } else if (num == 1) {
                    int temp = pqR.poll();
                    pq.remove(temp);
                }
            }
        }
        
        int[] answer = {0, 0};
        if (pqR.size() > 0) answer[0] = pqR.poll();
        if (pq.size() > 0) answer[1] = pq.poll();
        return answer;
    }
}