import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String str = br.readLine();
	    
	    int count = 0; // 앞 글자와 다른 부분
	    char word = str.charAt(0); // 첫 번째 글자
	    
	    for (int i = 1; i < str.length(); i++) {
	        if (word != str.charAt(i)) {
	            word = str.charAt(i);
	            count++;
	        }
	    }
	    
	    System.out.println((count / 2) + (count % 2));
	}
}