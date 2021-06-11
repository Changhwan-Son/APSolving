package jun.week2;

import java.io.*;
import java.util.StringTokenizer;

public class fail_SWEA_4317_칩생산 {

	static int[] dx = { 0, 0, 1, 1 };
	static int[] dy = { 0, 1, 0, 1 };
	static int[][] map;
	static int count, H, W;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());

		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			count = 0;
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			count = getMaxChips(0);

			sb.append("#").append(test).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}

	static int getMaxChips(int stage) {
		int x = stage / W;
		int y = stage % W;
		int max = 0;
		
		if(x == H-2 && y == W-1)
			return 0;

		if (y < W - 1 && x < H - 1) {
			if (map[x][y] + map[x][y + 1] + map[x + 1][y] + map[x + 1][y + 1] == 0) {
				fill(x, y, 1);
				int ret = getMaxChips(stage + 1) + 1;
				if (ret > max)
					max = ret;
				fill(x, y, 0);
			}
		}
		int ret = getMaxChips(stage + 1);
		if (ret > max)
			max = ret;

		return max;
	}

	static void fill(int x, int y, int val) {
		map[x][y] = map[x + 1][y] = map[x][y + 1] = map[x + 1][y + 1] = val;
	}
}
