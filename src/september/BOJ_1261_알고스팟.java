package september;

import java.io.*;
import java.util.*;

public class BOJ_1261_알고스팟 {

	static int M, N, answer = 0;
	static int[] dr = { 0, 1, -1, 0 };
	static int[] dc = { 1, 0, 0, -1 };
	static int[][] map, dist;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dist = new int[N][M];
		String str = null;
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		bfs();

		System.out.println(answer);
	}

	static void bfs() {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		pq.add(new int[] { 0, 0, 0 });
		dist[0][0] = 0;
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int r = cur[0];
			int c = cur[1];

			if (r == N - 1 && c == M - 1) {
				answer = cur[2];
				return;
			}

			for (int i = 0; i < 4; i++) {
				int mr = r + dr[i];
				int mc = c + dc[i];

				if (mr < 0 || mc < 0 || mr >= N || mc >= M)
					continue;

				if (dist[mr][mc] > dist[r][c] + map[mr][mc]) {
					dist[mr][mc] = dist[r][c] + map[mr][mc];
					pq.add(new int[] { mr, mc, dist[mr][mc] });
				}

			}
		}
	}
}
