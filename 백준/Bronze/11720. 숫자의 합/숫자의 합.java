import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 54321
        String sNum = sc.next();
        // ['5', '4', '3', '2', '1']
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for (int i = 0; i < cNum.length; i++) {
            sum += cNum[i] - '0'; // char -> int
        }
        System.out.println(sum);
    }
}