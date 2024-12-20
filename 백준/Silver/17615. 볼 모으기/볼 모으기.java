import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        
        int redCnt = 0;
        int blueCnt = 0;
        
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 'R') redCnt++;
            else blueCnt++;
        }
        
        int firstCnt = 0;
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) { // RB
            if (input[i] == 'R') firstCnt++;
            else break;
        }
        answer = Math.min(answer, redCnt - firstCnt);
        firstCnt = 0;
        
        for (int i = n - 1; i >= 0; i--) { // BR
            if (input[i] == 'R') firstCnt++;
            else break;
        }
        answer = Math.min(answer, redCnt - firstCnt);
        firstCnt = 0;
        
        for (int i = 0; i < n; i++) { // RB
            if (input[i] == 'B') firstCnt++;
            else break;
        }
        answer = Math.min(answer, blueCnt - firstCnt);
        firstCnt = 0;
        
        for (int i = n - 1; i >= 0; i--) { // BR
            if (input[i] == 'B') firstCnt++;
            else break;
        }
        answer = Math.min(answer, blueCnt - firstCnt);
        
        System.out.println(answer);
    }
}
