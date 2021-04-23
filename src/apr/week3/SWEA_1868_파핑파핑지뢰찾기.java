package apr.week3;

import java.io.*;

public class SWEA_1868_파핑파핑지뢰찾기 {

	static int[] dx = { 1, 1, 1, 0, 0, -1, -1, -1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int[][] map;
	static int count, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			count = 0;

			for (int i = 0; i < N; i++) {
				String str = in.readLine();
				for (int j = 0; j < N; j++) {
					char c = str.charAt(j);
					if (c == '.')
						map[i][j] = -1;
					else if (c == '*')
						map[i][j] = -100;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == -1) {
						if (check(i, j) == 0)
							count++;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == -1) {
						count++;
					}
				}
			}

			System.out.println("#" + tc + " " + count);
		}
	}

	static int check(int x, int y) {
		int tmp = 0;
		for (int i = 0; i < 8; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			if (mx < 0 || my < 0 || mx >= N || my >= N)
				continue;
			if (map[mx][my] == -100)
				tmp++;
		}

		if (tmp == 0) {
			map[x][y] = tmp;
			for (int i = 0; i < 8; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				if (mx < 0 || my < 0 || mx >= N || my >= N)
					continue;
				if (map[mx][my] == -1)
					map[mx][my] = check(mx, my);
			}
		}

		return tmp;
	}
}
