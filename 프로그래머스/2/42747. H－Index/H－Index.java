import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        for (int h = citations[citations.length - 1]; h >= 0; h--) {
            int cnt = 0;
            for (int citation : citations) {
                if (citation >= h) cnt++;
            }
            if (cnt >= h) return h;
        }
        int answer = 0;
        return answer;
    }
}