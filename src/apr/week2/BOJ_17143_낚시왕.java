package apr.week2;

import java.io.*;
import java.util.*;

public class BOJ_17143_낚시왕 {
	static class Shark {
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

	}

	static int[][] map;
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, 1, -1 };
	static int answer, R, C;
	static Shark[] sh;
	static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R + 1][C + 1];

		int M = Integer.parseInt(st.nextToken());
		sh = new Shark[M + 1];
		queue = new LinkedList<int[]>();

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			sh[i] = new Shark(r, c, s, d, z);
			map[r][c] = i;
		}

		answer = 0;
		for (int i = 1; i <= C; i++) {
			for (int a = 1; a <= R; a++) {
				for (int b = 1; b <= C; b++) {
					if (map[a][b] != 0)
						queue.add(new int[] { a, b });
				}
			}

			// 상어 잡기
			for (int j = 1; j <= R; j++) {
				if (map[j][i] != 0) {
					System.out.println(sh[map[j][i]].z);
					answer += sh[map[j][i]].z;
					map[j][i] = 0;
					break;
				}
			}
			
			// 상어 이동
			move();
			for (int a = 1; a <= R; a++) {
				for (int b = 1; b <= C; b++) {
					System.out.print(map[a][b]);
				}
				System.out.println();
			}
			System.out.println();
		}

		System.out.println(answer);
	}

	static void move() {
		while (!queue.isEmpty()) {
			int i = queue.peek()[0];
			int j = queue.poll()[1];
			if (map[i][j] != 0) {
				int c = map[i][j];
				int mi = i;
				int mj = j;
				int t = sh[map[i][j]].s;
				int d = sh[map[i][j]].d;
				int p = 1;
				if (d == 1 || d == 2)
					t %= (R * 2 - 2);
				else
					t %= (C * 2 - 2);
				while (t-- > 0) {
					mi += dx[d] * p;
					mj += dy[d] * p;
					if (mi < 1 || mi > R || mj < 1 || mj > C) {
						p *= -1;
						mi += dx[d] * p * 2;
						mj += dy[d] * p * 2;
					}
				}
				if (map[mi][mj] != 0) {
					map[mi][mj] = sh[map[mi][mj]].z > sh[c].z ? map[mi][mj] : c;
				} else {
					map[mi][mj] = c;
				}
				System.out.println(i + " " + j + " " + mi + " " + mj);
				map[i][j] = 0;
			}

		}
	}
}
