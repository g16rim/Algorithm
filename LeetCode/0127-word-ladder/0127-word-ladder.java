import java.util.*;

class Solution {
    private class Node {
        String word;
        int count;

        public Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[] visited = new boolean[wordList.size()];
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(beginWord, 1));

        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp.word.equals(endWord)) {
                return temp.count;
            }

            for (int i = 0; i < wordList.size(); i++) {
                int diff = 0;
                for (int j = 0; j < wordList.get(i).length(); j++) {
                    if (temp.word.charAt(j) != wordList.get(i).charAt(j)) {
                        diff++;
                    }
                }

                if (!visited[i] && diff == 1) {
                    q.add(new Node(wordList.get(i), temp.count + 1));
                    visited[i] = true;
                }
            }
        }

        return 0;
    }
}