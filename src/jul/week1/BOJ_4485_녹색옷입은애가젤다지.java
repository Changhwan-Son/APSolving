package jul.week1;

import java.io.*;
import java.util.*;

public class BOJ_4485_녹색옷입은애가젤다지 {

	static int N;
	static int[][] map, dp;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int num = 1;
		while (true) {
			N = Integer.parseInt(in.readLine());

			if (N == 0)
				break;

			map = new int[N][N];
			dp = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dp[i][j] = Integer.MAX_VALUE;
				}
			}
			dp[0][0] = map[0][0];
			bfs();

			sb.append("Problem ").append(num).append(": ").append(dp[N - 1][N - 1]).append("\n");
			num++;
		}
		
		System.out.println(sb);
	}

	static void bfs() {

		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { 0, 0 });

		while (!queue.isEmpty()) {
			int x = queue.peek()[0];
			int y = queue.poll()[1];

			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];

				if (mx < 0 || my < 0 || mx >= N || my >= N)
					continue;

				if (dp[mx][my] > dp[x][y] + map[mx][my]) {
					queue.add(new int[] { mx, my });
					dp[mx][my] = map[mx][my] + dp[x][y];
				}
			}
		}
	}
}
