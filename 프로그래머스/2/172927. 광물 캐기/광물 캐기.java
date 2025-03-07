import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int totalPicks = (picks[0] + picks[1] + picks[2]) * 5;
        totalPicks = Math.min(totalPicks, minerals.length);
        
        List<int[]> groups = new ArrayList<>();
        
        // 광물 5개씩 묶기
        for (int i = 0; i < totalPicks; i += 5) {
            int dia = 0, iron = 0, stone = 0;
            for (int j = i; j < i + 5 && j < totalPicks; j++) {
                if ("diamond".equals(minerals[j])) dia++;
                else if ("iron".equals(minerals[j])) iron++;
                else if ("stone".equals(minerals[j])) stone++;
            }
            groups.add(new int[] {dia, iron, stone});
        }
        
        // 중요도 기준 정렬
        groups.sort((a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            if (a[1] != b[1]) return b[1] - a[1];
            return b[2] - a[2];
        });
        
        // 곡괭이 배정
        int answer = 0;
        for (int[] group : groups) {
            if (picks[0] > 0) {
                answer += group[0] + group[1] + group[2];
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += group[0] * 5 + group[1] + group[2];
                picks[1]--;
            } else if (picks[2] > 0) {
                answer += group[0] * 25 + group[1] * 5 + group[2];
                picks[2]--;
            } else break;
        }
        
        return answer;
    }
}