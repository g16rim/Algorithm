import java.util.*;

class Solution {
    public int solution(String dirs) {
        int r = 0, c = 0;
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < dirs.length(); i++) {
            char d = dirs.charAt(i);
            int nr = r, nc = c;
            // 이동
            if (d == 'D') nc--;
            else if (d == 'U') nc++;
            else if (d == 'L') nr--;
            else if (d == 'R') nr++;
            // 범위 밖
            if (nr < -5 || nr > 5 || nc < -5 || nc > 5) continue;
            // 경로 저장
            set.add(r + "," + c + "," + nr + "," + nc);
            set.add(nr + "," + nc + "," + r + "," + c);
            // 위치 갱신
            r = nr;
            c = nc;
        }
        
        
        return set.size() / 2;
    }
}