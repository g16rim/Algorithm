class Solution {
    public int getSecond(String time) {
        int min = Integer.parseInt(time.split(":")[0]);
        int sec = Integer.parseInt(time.split(":")[1]);
        return min * 60 + sec;
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {       
        int posSec = getSecond(pos);
        int startSec = getSecond(op_start);
        int endSec = getSecond(op_end);
        // 오프닝 건너뛰기
        if (startSec <= posSec && posSec <= endSec) {
            posSec = endSec;
        }
        
        int lenSec = getSecond(video_len);
        
        // 명령어 실행
        for (String command : commands) {
            if ("next".equals(command)) {
                posSec += 10;
                posSec = Math.min(posSec, lenSec);
            } else if ("prev".equals(command)) {
                posSec -= 10;
                posSec = Math.max(posSec, 0);
            }
            
            // 오프닝 건너뛰기
            if (startSec <= posSec && posSec <= endSec) {
                posSec = endSec;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int min = posSec / 60;
        if (min < 10) sb.append("0");
        sb.append(min).append(":");
        int sec = posSec % 60;
        if (sec < 10) sb.append("0");
        sb.append(sec);
        return sb.toString();
    }
}