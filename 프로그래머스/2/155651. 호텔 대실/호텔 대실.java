import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] times = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            times[i][0] = toMinutes(book_time[i][0]);
            times[i][1] = toMinutes(book_time[i][1]) + 10;  // 청소 시간 10분 추가
        }
        
        Arrays.sort(times, (a, b) -> a[0] - b[0]); // 입실 시간 기준 정렬
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int[] time : times) {
            if (!pq.isEmpty() && pq.peek() <= time[0]) { 
                pq.poll();
            }
            pq.add(time[1]); // 퇴실 시간
        }
        
        return pq.size();
    }
    
    int toMinutes(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}