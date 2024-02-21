import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static List<Character> vowel = new ArrayList<>();;
	static List<Character> consonant = new ArrayList<>();;
	static int L, C;
	static char[] arr;
	static Set<String> result = new HashSet<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new char[L];
		for (int i = 0; i < C; i++) {
			String input = st.nextToken();
			if (new String("aeiou").contains(input)) {
				vowel.add(input.charAt(0));
			} else {
				consonant.add(input.charAt(0));
			}
		}
		makeAmho(0, 0, 0, 0);
		List<String> printArr = new ArrayList<>(result);
		Collections.sort(printArr);
		for (String s : printArr) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}
	
	static void makeAmho(int vIdx, int vCnt, int cIdx, int cCnt) {
		if (vCnt + cCnt == L) {
			if (vCnt < 1 || cCnt < 2) return; // 잘못 고름			
			char[] sortArr = new char[L];
			for (int i = 0; i < L; i++) {
				sortArr[i] = arr[i];
			}
			Arrays.sort(sortArr);
			result.add(new String(sortArr));
			return;
		}
		
		if (vIdx < vowel.size()) {
			arr[vCnt++ + cCnt] = vowel.get(vIdx);
			makeAmho(vIdx + 1, vCnt, cIdx, cCnt);
			
			vCnt--;
			makeAmho(vIdx + 1, vCnt, cIdx, cCnt);
		}
		
		if (cIdx < consonant.size()) {
			arr[vCnt + cCnt++] = consonant.get(cIdx);
			makeAmho(vIdx, vCnt, cIdx + 1, cCnt);
			
			cCnt--;
			makeAmho(vIdx, vCnt, cIdx + 1, cCnt);
		}
	}
	
}