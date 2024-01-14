import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = 1000 - Integer.parseInt(br.readLine());
	    int count = 0;
	    
	    int[] coinTypes = {500, 100, 50, 10, 5, 1};
	    
	    for(int i = 0; i < coinTypes.length; i++) {
	        count += n / coinTypes[i];
	        n %= coinTypes[i];
	    }
	    
	    System.out.println(count);
	}
}