import java.util.*;

class Solution {
    class Word {
        String word;
        int cnt;
        
        Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        Queue<Word> q = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        q.add(new Word(begin, 0));
        
        while (!q.isEmpty()) {
            Word cur = q.poll();
            
            if (cur.word.equals(target)) return cur.cnt;
            
            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;
                
                int diff = 0;
                for (int j = 0; j < begin.length(); j++) {
                    if (cur.word.charAt(j) != words[i].charAt(j)) {
                        diff++;
                    }
                }
                if (diff == 1) {
                    q.add(new Word(words[i], cur.cnt + 1));
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }
}