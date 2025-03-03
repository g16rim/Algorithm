class Solution {
    int[] arr = new int[5];
    int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        comb(0, 1, n, q, ans);
        return answer;
    }
    
    void comb(int cnt, int start, int n, int[][] q, int[] ans) {
        if (cnt == 5) {
            for (int i = 0; i < q.length; i++) {
                int match = 0;
                for (int a : arr) {
                    for (int val : q[i]) {
                        if (a == val) match++;
                    }
                }
                if (match != ans[i]) return;
            }
            answer++;
            return;
        }
        
        for (int i = start; i <= n; i++) {
            arr[cnt] = i;
            comb(cnt + 1, i + 1, n, q, ans);
        }
    }
}