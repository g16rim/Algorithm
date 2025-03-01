import java.util.*;

class Solution {
    class Task implements Comparable<Task> {
        int num;
        int requestTime;    // 요청시간
        int runningTime;    // 소요시간
        
        Task(int num, int requestTime, int runningTime) {
            this.num = num;
            this.requestTime = requestTime;
            this.runningTime = runningTime;
        }
        
        @Override
        public int compareTo(Task o) {
            if (this.runningTime == o.runningTime) {
                if (this.requestTime == o.requestTime) {
                    return Integer.compare(this.num, o.num);
                }
                return Integer.compare(this.requestTime, o.requestTime);
            }
            return Integer.compare(this.runningTime, o.runningTime);
        }
    }
    
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);   // 요청시간 기준으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int sum = 0;
        int time = 0;
        int idx = 0;
        int count = jobs.length;
        
        while (count > 0) {
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.add(jobs[idx++]);
            }
            
            if (!pq.isEmpty()) {
                int[] task = pq.poll();
                time += task[1];
                sum += (time - task[0]);
                count--;
            } else {
                time = jobs[idx][0];
            }
        }
        
        return sum / jobs.length;
    }
}