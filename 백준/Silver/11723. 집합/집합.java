import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        Set<Integer> s = new HashSet<>();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                s.add(x);
            } else if (command.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                s.remove(x);
            } else if (command.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                if (s.contains(x)) sb.append("1\n");
                else sb.append("0\n");

            } else if (command.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                if (s.contains(x)) s.remove(x);
                else s.add(x);
            } else if (command.equals("all")) {
                s.clear();
                for (int i = 1; i <= 20; i++) s.add(i);
            } else if (command.equals("empty")) {
                s.clear();
            }
        }
        System.out.print(sb);
    }
}