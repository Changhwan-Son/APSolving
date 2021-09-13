package september;

import java.io.*;
import java.util.*;

public class BOJ_21610_마법사상어와비바라기 {

	static int N, M;
	static int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[][] map;
	static Queue<int[]> cloud;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		cloud = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cloud.add(new int[] { N - 1, 0 });
		cloud.add(new int[] { N - 1, 1 });
		cloud.add(new int[] { N - 2, 0 });
		cloud.add(new int[] { N - 2, 1 });

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			magic(d, s);
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer += map[i][j];
			}
		}

		System.out.println(answer);
	}

	static void magic(int d, int s) {
		boolean[][] check = new boolean[N][N];
		int len = cloud.size();
		for (int i = 0; i < len; i++) {
			int r = cloud.peek()[0];
			int c = cloud.poll()[1];

			int mr = r + (dr[d] * s) % N;
			int mc = c + (dc[d] * s) % N;

			if (mr < 0)
				mr += N;
			else if (mr >= N)
				mr -= N;

			if (mc < 0)
				mc += N;
			else if (mc >= N)
				mc -= N;

			check[mr][mc] = true;
			map[mr][mc]++;
			cloud.add(new int[] { mr, mc });
		}

		for (int i = 0; i < len; i++) {
			int r = cloud.peek()[0];
			int c = cloud.poll()[1];

			int count = 0;
			for (int j = 0; j < 4; j++) {
				int mr = r + dr[2 * j + 1];
				int mc = c + dc[2 * j + 1];

				if (mr < 0 || mr >= N || mc < 0 || mc >= N)
					continue;

				if (map[mr][mc] > 0)
					count++;
			}
			map[r][c] += count;
		}

		cloud.clear();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!check[i][j] && map[i][j] >= 2) {
					cloud.add(new int[] { i, j });
					map[i][j] -= 2;
				}
			}
		}
	}
}
