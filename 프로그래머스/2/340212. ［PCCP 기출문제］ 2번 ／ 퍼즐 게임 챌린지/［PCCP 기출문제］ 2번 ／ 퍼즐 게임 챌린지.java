class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int start = 1;
        int end = 100000;
        
        while (start <= end) {
            int level = (start + end) / 2;
            long totalTime = getTotalTime(level, diffs, times);
            
            if (totalTime <= limit) {
                answer = level;       // 현재 숙련도로 해결 가능
                end = level - 1;      // 더 작은 숙련도로도 해결 가능한지 탐색
            } else {
                start = level + 1;    // 현재 숙련도로 해결 불가능, 더 큰 숙련도를 탐색
            }
        }
            
        return answer;
    }
    
    long getTotalTime(int level, int[] diffs, int[] times) {
        long totalTime = 0L;
        
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                totalTime += times[i];
            } else {
                int count = diffs[i] - level;
                int prev = 0;
                if (i > 0) prev = times[i - 1];
                totalTime += (count * (times[i] + prev) + times[i]);
            }
        }
        
        return totalTime;
    }
}