import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
// 투포인터
    public static void main(String[] args) throws  Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int result = 0;
        int i = 0, j = N - 1;
        while (i < j) {
            if (arr[i] + arr[j] == M) {
                result++;
                i++;
                j--;
            } else if (arr[i] + arr[j] < M) {
                i++;
            } else {
                j--;
            }
        }

        System.out.println(result);
        br.close();
    }

}