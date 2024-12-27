import java.io.*;
import java.util.*;

public class Main {
    static int n, m, r, rN, rM;
    static int[][] arr, resultArr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        st = new StringTokenizer(br.readLine());
        while (r-- > 0) {
            int command = Integer.parseInt(st.nextToken());
            
            switch (command) {
                case 1:
                    rotate1();
                    break;
                case 2:
                    rotate2();
                    break;
                case 3:
                    rotate3();
                    break;
                case 4:
                    rotate4();
                    break;
                case 5:
                    rotate5();
                    break;
                case 6:
                    rotate6();
            }
            
            n = rN;
            m = rM;
            arr = resultArr;
        }
        
        print();
        System.out.print(sb);
    }
    
    static void rotate1() {
        rN = n;
        rM = m;
        resultArr = new int[rN][rM];
        
        for (int i = 0; i < rN; i++) {
            for (int j = 0; j < rM; j++) {
                resultArr[rN - i - 1][j] = arr[i][j];
            }
        }
    }
    
    static void rotate2() {
        rN = n;
        rM = m;
        resultArr = new int[rN][rM];
        
        for (int i = 0; i < rN; i++) {
            for (int j = 0; j < rM; j++) {
                resultArr[i][rM - j - 1] = arr[i][j];
            }
        }
    }
    
    static void rotate3() {
        rN = m;
        rM = n;
        resultArr = new int[rN][rM];
        
        for (int i = 0; i < rN; i++) {
            for (int j = 0; j < rM; j++) {
                resultArr[i][rM - j - 1] = arr[j][i];
            }
        }
    }
    
    static void rotate4() {
        rN = m;
        rM = n;
        resultArr = new int[rN][rM];
        
        for (int i = 0; i < rN; i++) {
            for (int j = 0; j < rM; j++) {
                resultArr[rN - i - 1][j] = arr[j][i];
            }
        }
    }
    
    static void rotate5() {
        rN = n;
        rM = m;
        resultArr = new int[rN][rM];
        
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                resultArr[i][j + m / 2] = arr[i][j];
            }
        }
        
        for (int i = 0; i < n / 2; i++) {
            for (int j = m / 2; j < m; j++) {
                resultArr[i + n / 2][j] = arr[i][j];
            }
        }
        
        for (int i = n / 2; i < n; i++) {
            for (int j = m / 2; j < m; j++) {
                resultArr[i][j - m / 2] = arr[i][j];
            }
        }
        
        for (int i = n / 2; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                resultArr[i - n / 2][j] = arr[i][j];
            }
        }
    }
    
    static void rotate6() {
        rN = n;
        rM = m;
        resultArr = new int[rN][rM];
        
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                resultArr[i + n / 2][j] = arr[i][j];
            }
        }
        
        for (int i = 0; i < n / 2; i++) {
            for (int j = m / 2; j < m; j++) {
                resultArr[i][j - m / 2] = arr[i][j];
            }
        }
        
        for (int i = n / 2; i < n; i++) {
            for (int j = m / 2; j < m; j++) {
                resultArr[i - n / 2][j] = arr[i][j];
            }
        }
        
        for (int i = n / 2; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                resultArr[i][j + m / 2] = arr[i][j];
            }
        }
    }
    
    static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]);
                if (j != m - 1) sb.append(" ");
            }
            sb.append("\n");
        }
    }
}
