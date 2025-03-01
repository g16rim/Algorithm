class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        int n = schedules.length;
        
        for (int i = 0; i < n; i++) {
            int time = schedules[i] + 10;
            int hour = time / 100;
            int minute = time % 100;
            if (minute >= 60) {
                minute -= 60;
                hour += 1;
            }
            // System.out.println(hour + " " + minute);
            
            int day = startday;
            boolean attend = true;
            
            for (int j = 0; j < 7; j++) {
                if (day == 6 || day == 7) {
                    day++;
                    if (day == 8) day = 1;
                    continue; // 주말 pass
                }
                
                int attendHour = timelogs[i][j] / 100;
                int attendMinute = timelogs[i][j] % 100;
                if (attendMinute >= 60) {
                    attendMinute -= 60;
                    attendHour += 1;
                }
                // System.out.println(attendHour + " " + attendMinute);
                
                if ((attendHour == hour && attendMinute > minute) || attendHour > hour) {
                    attend = false;
                }
                
                day++;
                if (day == 8) day = 1;
            }
            
            if (attend) answer++;
        }
        
        return answer;
    }
}