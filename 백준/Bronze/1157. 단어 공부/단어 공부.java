import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] alphabet = new int[26];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		word = word.toLowerCase();

		for (int i = 0; i < word.length(); i++) {
			alphabet[word.charAt(i)- 'a']++;
		}
		
		char result = '?';
		int max = -1;
		for (int i = 0; i < 26; i++) {
			if (alphabet[i] > max) {
				max = alphabet[i];
				result = (char) (i + 'A');
			} else if (alphabet[i] == max) {
				result = '?';
			}
		}
		
		System.out.println(result);
	}
}