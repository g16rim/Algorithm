class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int r = 0, c = 0;
        // 우, 하, 좌, 상
        int[] dr = {0, 1, 0, -1}; 
        int[] dc = {1, 0, -1, 0};
        int cnt = 1;
        int dirIdx = 0;

        while (cnt <= n * n){
            answer[r][c] = cnt++;

            int nr = r + dr[dirIdx % 4];
            int nc = c + dc[dirIdx % 4];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n || answer[nr][nc] != 0){
                dirIdx++;
            }

            r += dr[dirIdx % 4];
            c += dc[dirIdx % 4];
        }
        
        return answer;
    }
}