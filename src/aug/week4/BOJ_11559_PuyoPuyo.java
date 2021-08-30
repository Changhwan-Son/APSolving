package aug.week4;

import java.io.*;
import java.util.*;

public class BOJ_11559_PuyoPuyo {

	static int answer = 0;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String st = null;
		map = new char[12][6];
		for (int i = 0; i < 12; i++) {
			st = in.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = st.charAt(j);
			}
		}

		while (check()) {
			answer++;
			move();
		}

		System.out.println(answer);
	}

	static void move() {
		Queue<Character> ch = new LinkedList<Character>();
		for (int j = 0; j < 6; j++) {
			ch.clear();
			for (int i = 11; i >= 0; i--) {
				if (map[i][j] != '.')
					ch.add(map[i][j]);
			}

			for (int i = 11; i >= 0; i--) {
				if (ch.isEmpty())
					map[i][j] = '.';
				else
					map[i][j] = ch.poll();
			}
		}

	}

	static boolean check() {
		boolean[][] visited = new boolean[12][6];
		boolean flag = false;
		Queue<int[]> q = new LinkedList<>();
		List<int[]> list = new ArrayList<>();

		for (int i = 11; i >= 0; i--) {
			for (int j = 5; j >= 0; j--) {
				list.clear();
				if (!visited[i][j] && map[i][j] != '.') {
					q.add(new int[] { i, j });
					visited[i][j] = true;
					while (!q.isEmpty()) {
						int x = q.peek()[0];
						int y = q.poll()[1];
						char cur = map[i][j];
						list.add(new int[] { x, y });

						for (int d = 0; d < 4; d++) {
							int mx = x + dx[d];
							int my = y + dy[d];

							if (mx < 0 || my < 0 || mx >= 12 || my >= 6)
								continue;

							if (visited[mx][my] || map[mx][my] != cur)
								continue;

							visited[mx][my] = true;
							q.add(new int[] { mx, my });
						}
					}
					if (list.size() >= 4) {
						flag = true;
						for (int[] arr : list) {
							map[arr[0]][arr[1]] = '.';
						}
					}
				}
			}
		}
		return flag;
	}
}
