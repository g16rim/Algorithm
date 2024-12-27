import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if ((arr[i] + arr[j]) == (sum - 100)) {
                    arr[i] = 0;
                    arr[j] = 0;
                    break;
                }
            }
            if (arr[i] == 0) break;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if (arr[i] > 0) sb.append(arr[i]).append("\n");
        }
        
        System.out.print(sb);
    }
}
