import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        String word = br.readLine();
        int result = 0;
        
        // while (sentence.contains(word)) {
            // sentence = sentence.replaceFirst(word, ".");
            // result++;
        // }
        int idx = sentence.indexOf(word);
        while (idx != -1) {
            result++;
            idx = sentence.indexOf(word, idx + word.length());
        }
        System.out.println(result);
    }
}
