import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<HashSet<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<>()); // dp.get(0)을 위해서 넣어둠
        for (int i = 1; i <= 8; i++) {
            dp.add(new HashSet<>()); // 5 55 555 ... 55555555
            dp.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }
        
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                for (int num1 : dp.get(j)) {
                    for (int num2 : dp.get(i - j)) {
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if (num2 != 0) {
                            dp.get(i).add(num1 / num2);
                        }
                    }
                }
            }
            if (dp.get(i).contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}