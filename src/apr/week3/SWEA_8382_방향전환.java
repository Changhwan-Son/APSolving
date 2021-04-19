package apr.week3;

import java.io.*;
import java.util.*;

public class SWEA_8382_방향전환 {

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean[][] visited;
	static int x2, y2, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken()) + 100;
			int y1 = Integer.parseInt(st.nextToken()) + 100;
			x2 = Integer.parseInt(st.nextToken()) + 100;
			y2 = Integer.parseInt(st.nextToken()) + 100;
			min = Integer.MAX_VALUE;

			// 가로방향 먼저 접근
			visited = new boolean[201][201];
			bfs1(x1, y1, 0);

			// 세로방향 접근
			visited = new boolean[201][201];
			bfs1(x1, y1, 2);

			System.out.println("#" + tc + " " + min);
		}
	}

	static void bfs1(int x1, int y1, int p) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { x1, y1, 0, p });
		visited[x1][y1] = true;

		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int cnt = q.peek()[2];
			int pre = q.poll()[3];

			if (x == x2 && y == y2) {
				min = Math.min(min, cnt);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];

				if (mx < 0 || my < 0 || mx >= 201 || my >= 201 || visited[mx][my])
					continue;

				if (pre < 2 && i >= 2) {
					visited[mx][my] = true;
					q.offer(new int[] { mx, my, cnt + 1, i });
				} else if (pre >= 2 && i < 2) {
					visited[mx][my] = true;
					q.offer(new int[] { mx, my, cnt + 1, i });
				}
			}
		}
	}
}
