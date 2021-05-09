package may.week1;
/*
 * 2021 K 인턴십 코딩테스트 
 */
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
	static char[][] map;
	static int tmp;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public int[] solution(String[][] places) {
		int[] answer = new int[5];
		map = new char[5][5];
		for (int t = 0; t < 5; t++) {
			tmp = 1;
			for (int i = 0; i < 5; i++) {
				String s = places[t][i];
				for (int j = 0; j < 5; j++) {
					map[i][j] = s.charAt(j);
				}
			}

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (map[i][j] == 'P') {
						bfs(i, j);
					}

					if (tmp == 0)
						break;
				}
				if (tmp == 0)
					break;
			}

			answer[t] = tmp;
		}

		return answer;
	}

	void bfs(int r, int c) {
		boolean[][] visited = new boolean[5][5];
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { r, c, 0 });
		visited[r][c] = true;
		while (!q.isEmpty()) {
			int cr = q.peek()[0];
			int cc = q.peek()[1];
			int ccnt = q.poll()[2];

			if (ccnt == 2)
				break;

			for (int i = 0; i < 4; i++) {
				int mr = cr + dr[i];
				int mc = cc + dc[i];
				if (mr < 0 || mc < 0 || mr >= 5 || mc >= 5 || visited[mr][mc] || map[mr][mc] == 'X')
					continue;

				if (map[mr][mc] == 'P') {
					tmp = 0;
				}

				visited[mr][mc] = true;
				q.add(new int[] { mr, mc, ccnt + 1 });
			}
			if (tmp == 0)
				break;
		}

	}
}
