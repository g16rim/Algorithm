class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String tree : skill_trees) {
            int idx = 0;                            // skill 순서 체크용
            boolean possible = true;

            for (char ch : tree.toCharArray()) {
                if (skill.indexOf(ch) != -1) {      // 선행 스킬에 있다면
                    if (ch == skill.charAt(idx)) {
                        idx++;                      // 올바른 순서로 배움
                    } else {
                        possible = false;           // 순서 틀림
                        break;
                    }
                }
            }

            if (possible) answer++;
        }

        return answer;
    }
}
