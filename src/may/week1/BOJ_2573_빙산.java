package may.week1;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2573_빙산 {

	static int N, M, mount;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int[][] map, tmp;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		tmp = new int[N][M];
		visited = new boolean[N][M];
		int year = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				tmp[i][j] = n;
			}
		}

		while (true) {
			year++;
			mount = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					melt(i, j);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					visited[i][j] = false;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (tmp[i][j] != 0 && !visited[i][j]) {
						getMount(i, j);
						mount++;
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = tmp[i][j];
				}
			}

			if (mount >= 2)
				break;

			if (mount == 0) {
				year = 0;
				break;
			}
		}
		System.out.println(year);
	}

	private static void getMount(int r, int c) {
		visited[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int mr = r + dr[d];
			int mc = c + dc[d];

			if (mr < 0 || mc < 0 || mr >= N || mc >= M || visited[mr][mc])
				continue;

			if (tmp[mr][mc] != 0)
				getMount(mr, mc);
		}
	}

	private static void melt(int r, int c) {

		int cnt = 0;
		for (int d = 0; d < 4; d++) {
			int mr = r + dr[d];
			int mc = c + dc[d];

			if (mr < 0 || mc < 0 || mr >= N || mc >= M)
				continue;

			if (map[mr][mc] == 0)
				cnt++;
		}

		tmp[r][c] -= cnt;
		if (tmp[r][c] < 0)
			tmp[r][c] = 0;
	}
}
