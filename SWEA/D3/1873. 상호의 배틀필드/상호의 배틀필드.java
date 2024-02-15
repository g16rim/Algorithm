import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int H, W, N, x, y, dir;
	static char[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static String input;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
			}
			br.readLine();
			input = br.readLine();
			
			// 전차 위치 찾기
			findTankPosAndDir();
			
			for (int i = 0; i < input.length(); i++) {
				char command = input.charAt(i);
				if (command == 'U') {
					U();
				} else if (command == 'D') {
					D();
				} else if (command == 'L') {
					L();
				} else if (command == 'R') {
					R();
				} else if (command == 'S') {
					S();
					findTankPosAndDir();
				}
			}
			
			// 출력
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
		
	}
	
	static void findTankPosAndDir() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == '^') {
					x = i; y = j; dir = 0;
				} else if (map[i][j] == 'v') {
					x = i; y = j; dir = 1;
				} else if (map[i][j] == '<') {
					x = i; y = j; dir = 2;
				} else if (map[i][j] == '>') {
					x = i; y = j; dir = 3;
				}
			}
		}
	}
	
	static void U() {
		dir = 0;
		if (x - 1 >= 0 && map[x - 1][y] == '.') {
			map[x][y] = '.';
			x = x - 1;
		}
		map[x][y] = '^';
	}
	
	static void D() {
		dir = 1;
		if (x + 1 < H && map[x + 1][y] == '.') {
			map[x][y] = '.';
			x = x + 1;
		}
		map[x][y] = 'v';
	}
	
	static void L() {
		dir = 2;
		if (y - 1 >= 0 && map[x][y - 1] == '.') {
			map[x][y] = '.';
			y = y - 1;
		}
		map[x][y] = '<';
	}
	
	static void R() {
		dir = 3;
		if (y + 1 < W && map[x][y + 1] == '.') {
			map[x][y] = '.';
			y = y + 1;
		}
		map[x][y] = '>';
	}
	
	static void S() {
		// 다음에 전진할 좌표
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		// map 밖, 강철: #이면 return
		if (nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == '#') { 
			return;
		} else if (map[nx][ny] == '-' || map[nx][ny] == '.') { // .: 평지이거나 물: -,이면 그저 전진
			x = nx; y = ny;
			S();
		} else if (map[nx][ny] == '*') { // *: 벽돌이면
			map[nx][ny] = '.';
			return;
		}
	}

}