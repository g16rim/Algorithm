import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int min = 1;
        int max = distance;
        while (min <= max) {
            int mid = (min + max) / 2; // 우리가 정한 거리의 최솟값
            int prev = 0; // 직전 바위 위치
            int count = 0; // 제거한 바위 개수
            
            for (int rock : rocks) {
                if (rock - prev < mid) { // 거리의 최소값보다 작으면 바위 없애기
                    count++;
                } else { // 아니면 그 바위 없애기
                    prev = rock;
                }
            }
            if (distance - prev < mid) { // 도착지점과 마지막 바위 
                count++;
            }
            
            if (count > n) { // 제거한 개수가 n보다 크면 
                max = mid - 1; // 거리 줄이기 
            } else {
                answer = mid;
                min = mid + 1; // 거리 늘리기 
            }
        }
        
        return answer;
    }
}