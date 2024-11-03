class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        
        int n = attacks.length;
        int end = attacks[n - 1][0];
        int attack = 0;
        int seq = 0;
        
        for (int i = 0; i <= end; i++) {
            if (i == attacks[attack][0]) {
                answer -= attacks[attack][1];
                if (answer <= 0) {
                    return -1;
                }
                attack++;
                seq = 0;
            } else {
                answer = Math.min(health, answer + bandage[1]);
                seq++;
                if (seq == bandage[0]) {
                    answer = Math.min(health, answer + bandage[2]);
                    seq = 0;
                }
            }
        }
        
        return answer;
    }
}