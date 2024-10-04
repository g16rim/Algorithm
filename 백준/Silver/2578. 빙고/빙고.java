import java.io.*;
import java.util.*;

public class Main {
    static int[][] bingo = new int[5][5];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                setZero(num);
                // System.out.println(num);
                if (check() >= 3) {
                    System.out.println(i * 5 + (j + 1));
                    return;
                }
            }
        }
    }
    
    static void setZero(int n) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == n) {
                    bingo[i][j] = 0;
                    return;
                }
            }
        }
    }
    
    static int check() {
        int line = 0;
        
        // 가로
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 4 && bingo[i][j] == 0) line++;
                if (bingo[i][j] != 0) break; 
            }
        }
        
        // 세로
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 4 && bingo[j][i] == 0) line++;
                if (bingo[j][i] != 0) break; 
            }
        }
        
        // 대각선 좌 -> 우
        if (bingo[0][0] == 0 && bingo[1][1] == 0 && bingo[2][2] == 0 && bingo[3][3] == 0 && bingo[4][4] == 0) line++;      
        
        // 대각선 우 -> 좌
        if (bingo[0][4] == 0 && bingo[1][3] == 0 && bingo[2][2] == 0 && bingo[3][1] == 0 && bingo[4][0] == 0) line++;   
        
        return line;
    }
}
