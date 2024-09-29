import java.util.*;

class Solution {
    char[] alp = {'A', 'E', 'I', 'O', 'U'};
    List<String> dict = new ArrayList<>();
    int[] multiplier = {781, 156, 31, 6, 1};
    
    public int solution(String word) {
        // backtracking("", 0);
        // Collections.sort(dict);
        // return dict.indexOf(word);
        int answer = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (int j = 0; j < alp.length; j++) {
                if (alp[j] == c) {
                    answer += j * multiplier[i] + 1;
                    break;
                }
            }
        }
        return answer;
    }
    
    void backtracking(String temp, int cnt) {
        if (cnt > 5) return;
        
        dict.add(temp);
        
        for (int i = 0; i < alp.length; i++) {
            backtracking(temp + alp[i], cnt + 1);
        }
    }
}