import java.io.*;
import java.util.*;

public class Main {
    static int[] cache = new int[1000];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        for (int i = 0; i < s2.length(); i++) {
            int temp = 0; // 누적 최대값 변수
            for (int j = 0; j < s1.length(); j++) {
                if (temp < cache[j])
                    temp = cache[j];
                else if (s2.charAt(i) == s1.charAt(j))
                    cache[j] = temp + 1;
            }
        }

        int result = 0;
        for (int i = 0; i < s1.length(); i++)
            result = Math.max(result, cache[i]);
        System.out.println(result);
    }

}