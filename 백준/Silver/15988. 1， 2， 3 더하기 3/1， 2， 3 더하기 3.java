import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] arr = new long[1000001];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (arr[n] == 0) {
                for (int i = 4; i <= n; i++) {
                    arr[i] = (arr[i - 1] + arr[i - 2] + arr[i - 3]) % 1000000009L; 
                }
            }
            sb.append(arr[n]).append("\n");
        }
        System.out.println(sb);
    }
}