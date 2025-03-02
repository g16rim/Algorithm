class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] servers = new int[24];    // 증설된 서버의 수
        
        for(int i = 0; i < players.length; i++) {
            if (i > 0) {
                servers[i] += servers[i - 1];
            }
            
            int needed = players[i] / m - servers[i];   // 추가로 필요한 서버 수
            if (needed > 0) {
                answer += needed;
                servers[i] += needed;
                
                if (i + k < servers.length) {
                    servers[i + k] -= needed;
                }
            }
        }
        return answer;
    }
}