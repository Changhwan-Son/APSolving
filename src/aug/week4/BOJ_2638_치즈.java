package aug.week4;

import java.io.*;
import java.util.*;

public class BOJ_2638_치즈 {

	static int N, M;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] map, air;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		air = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		while (true) {
			flag = false;
			checkAir();
			melt();
			
			if(!flag)
				break;
			answer++;
		}

		System.out.println(answer);
	}

	static void melt() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 1)
					continue;

				count = 0;
				for (int d = 0; d < 4; d++) {
					int mx = i + dx[d];
					int my = j + dy[d];
					if (air[mx][my] == 1)
						count++;
				}
				if (count >= 2) {
					map[i][j] = 0;
					flag = true;
				}
			}
		}
	}

	static void checkAir() {
		air = new int[N][M];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		air[0][0] = 1;
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.poll()[1];

			for (int d = 0; d < 4; d++) {
				int mx = x + dx[d];
				int my = y + dy[d];

				if (mx < 0 || my < 0 || mx >= N || my >= M)
					continue;

				if (map[mx][my] == 1 || air[mx][my] == 1)
					continue;

				air[mx][my] = 1;
				q.add(new int[] { mx, my });
			}
		}
	}
}
