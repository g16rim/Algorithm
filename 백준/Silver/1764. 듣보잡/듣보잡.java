import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        for (int i = 0; i < N; i++) s1.add(br.readLine());
        for (int i = 0; i < M; i++) s2.add(br.readLine());
        s1.retainAll(s2); // 교집합
        List<String> list = new ArrayList<>(s1);
        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for (String n : list) sb.append(n).append("\n");
        System.out.print(sb);
    }
}