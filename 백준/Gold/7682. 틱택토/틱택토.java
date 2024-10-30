import java.io.*;
import java.util.*;

public class Main {
    private static char[][] board;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            String input = br.readLine();
            if (input.equals("end")) break;
            
            board = new char[3][3];
            int xCnt = 0, oCnt = 0;
            
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = input.charAt(i * 3 + j);
                    if (board[i][j] == 'X') xCnt++;
                    else if (board[i][j] == 'O') oCnt++;
                }
            }
            
            if (xCnt - oCnt == 1) { // X가 마지막에 놓은 경우
                if (xCnt + oCnt == 9 && !check('O')) {
                    sb.append("valid\n");
                } else if (check('X') && !check('O')) {
                    sb.append("valid\n");
                } else {
                    sb.append("invalid\n");
                }
            } else if (xCnt == oCnt) { // O가 마지막에 놓은 경우
                if (!check('X') && check('O')) {
                    sb.append("valid\n");
                } else {
                    sb.append("invalid\n");
                }
            } else {
                sb.append("invalid\n");
            }
        }
        
        System.out.print(sb);
    }
    
    private static boolean check(char ch) {
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ch) cnt++;
            }
            if (cnt == 3) return true;
        }
        
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == ch) cnt++;
            }
            if (cnt == 3) return true;
        }
        
        if (board[0][0] == ch && board[1][1] == ch && board[2][2] == ch) return true;
        if (board[0][2] == ch && board[1][1] == ch && board[2][0] == ch) return true;
        return false;
    }
}
