package apr.week2;

import java.io.*;
import java.util.*;

public class SWEA_1953_탈주범검거 {

	static int N, M, R, C, L, map[][];
	static int[] dr = { -1, 0, 0, 1 }; // 상,좌,우,하
	static int[] dc = { 0, -1, 1, 0 }; // 상,좌,우,하
	static String[] type = {
		null,
		"0312",		// 1: 상하좌우 
		"03",		// 2: 상하 
		"12",		// 3: 좌우 
		"02",		// 4: 상우 
		"32",		// 5: 하우 
		"31",		// 6: 하좌
		"01"		// 7: 상좌 
	};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println("#" + t + " " + bfs());
		}

	}

	static int bfs() {
		int result = 0, time = 1;

		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][M];

		queue.offer(new int[] { R, C });
		visited[R][C] = true;
		++result;

		while (time++ < L) {
			int size = queue.size();
			while (size-- > 0) { // 동시간 대 처리
				int[] current = queue.poll();
				int r = current[0];
				int c = current[1];
				String info = type[map[r][c]];

				for (int d = 0, length = info.length(); d < length ; d++) {
					int dir = info.charAt(d) - '0';
					int mr = r + dr[dir];
					int mc = c + dc[dir];
					
					if(mr >= 0 && mr < N && mc >= 0 && mc < M 
							&& map[mr][mc] > 0
							&& type[map[mr][mc]].contains(Integer.toString(3 - dir))
							&& !visited[mr][mc]) {
						visited[mr][mc] = true;
						queue.add(new int[] {mr, mc});
						++result;
					}
				}
			}
		}

		return result;
	}

}
