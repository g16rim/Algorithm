import java.util.*;

class Solution {
    Set<Integer> primes = new HashSet<>();
    
    public int solution(String numbers) {
        char[] input = numbers.toCharArray();
        boolean[] visited = new boolean[input.length];
        backtracking(input, visited, "");
        return primes.size();
    }
    
    void backtracking(char[] input, boolean[] visited, String temp) {
        // System.out.println(temp);
        if (!temp.isEmpty()) {
            int num = Integer.parseInt(temp);
            if (isPrime(num)) {
                primes.add(num);
            }
        }
        
        for (int i = 0; i < input.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(input, visited, temp + input[i]);
                visited[i] = false;
            } 
        }
    }
    
    boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}