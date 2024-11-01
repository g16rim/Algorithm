import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        
        if (input[0] != 'q' || input.length % 5 != 0) {
            System.out.println(-1);
            return;
        }
        
        char[] duck = {'q', 'u', 'a', 'c', 'k'};
        boolean[] visited = new boolean[input.length];
        int idx = 0;
        int result = 0;
        
        for (int i = 0; i < input.length; i++) {
            List<Character> list = new ArrayList<>();
            
            for (int j = i; j < input.length; j++) {
                if (!visited[j] && input[j] == duck[idx]) {
                    idx++;
                    if (idx == 5) idx = 0;
                    list.add(input[j]);
                    visited[j] = true;
                }
            }
            
            if (list.size() != 0) {
                if (list.get(list.size() - 1) != 'k') {
                    System.out.println(-1);
                    return;
                }
                
                result++;
            }
        }
        
        System.out.println(result);
    }
}
