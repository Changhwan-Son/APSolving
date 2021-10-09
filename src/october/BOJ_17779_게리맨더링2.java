package october;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17779_게리맨더링2 {

	static int N, total;
	static int[][] map;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(in.readLine());
		map = new int[N + 1][N + 1];
		min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				total += map[i][j];
			}
		}

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				for (int d1 = 1; d1 < N; d1++) {
					for (int d2 = 1; d2 < N; d2++) {
						if (x + d1 + d2 > N)
							continue;
						if (y + d2 > N || y - d1 < 1)
							continue;

						func(x, y, d1, d2);
					}
				}
			}
		}
		System.out.println(min);
	}

	static void func(int x, int y, int d1, int d2) {
		boolean[][] check = new boolean[N + 1][N + 1];
		int[] count = new int[5];

		for (int i = 0; i <= d1; i++) {
			check[x + i][y - i] = true;
			check[x + d2 + i][y + d2 - i] = true;
		}
		for (int i = 0; i <= d2; i++) {
			check[x + i][y + i] = true;
			check[x + d1 + i][y - d1 + i] = true;
		}

		// 1번
		for (int i = 1; i < x + d1; i++) {
			for (int j = 1; j <= y; j++) {
				if (check[i][j])
					break;
				count[0] += map[i][j];
			}
		}
		// 2번
		for (int i = 1; i <= x + d2; i++) {
			for (int j = N; j > y; j--) {
				if (check[i][j])
					break;
				count[1] += map[i][j];
			}
		}
		// 3번
		for (int i = N; i >= x + d1; i--) {
			for (int j = 1; j < y - d1 + d2; j++) {
				if (check[i][j])
					break;
				count[2] += map[i][j];
			}
		}
		// 4번
		for (int i = N; i > x + d2; i--) {
			for (int j = N; j >= y - d1 + d2; j--) {
				if (check[i][j])
					break;
				count[3] += map[i][j];
			}
		}

		count[4] = total;
		for (int i = 0; i < 4; i++)
			count[4] -= count[i];

		Arrays.sort(count);
		min = Math.min(min, count[4] - count[0]);
	}
}
