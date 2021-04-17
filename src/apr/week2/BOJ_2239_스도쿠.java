package apr.week2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2239_스도쿠 {

	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		map = new int[9][9];
		String str = null;
		for (int i = 0; i < 9; i++) {
			str = in.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		sudoku(0, 0);
	}

	static void sudoku(int x, int y) {
		if (y == 9) {
			sudoku(x + 1, 0);
			return;
		}

		if (x == 9) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}

		if (map[x][y] == 0) {
			for (int num = 1; num <= 9; num++) {
				if (check(x, y, num)) {
					map[x][y] = num;
					sudoku(x, y + 1);
				}
			}
			map[x][y] = 0;
			return;
		}

		sudoku(x, y + 1);
	}

	private static boolean check(int x, int y, int num) {

		for (int idx = 0; idx < 9; idx++) {
			if (map[x][idx] == num)
				return false;
		}
		for (int idx = 0; idx < 9; idx++) {
			if (map[idx][y] == num)
				return false;
		}

		int mx = x -x % 3;
		int my = y - y % 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (map[mx + i][my + j] == num)
					return false;
			}
		}

		return true;
	}
}
