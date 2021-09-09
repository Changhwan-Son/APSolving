package september;

import java.io.*;
import java.util.*;

public class BOJ_20056_마법사상어와파이어볼 {

	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static List<FireBall> map[][];
	static int N, M, K;

	static class FireBall {
		int m;
		int d;
		int s;

		FireBall(int m, int d, int s) {
			this.m = m;
			this.d = d;
			this.s = s;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map[r][c].add(new FireBall(m, d, s));
		}

		for (int i = 0; i < K; i++)
			move();

		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (FireBall f : map[i][j])
					answer += f.m;
			}
		}

		System.out.println(answer);

	}

	static void move() {
		List<FireBall> tmp[][] = new ArrayList[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				tmp[i][j] = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!map[i][j].isEmpty()) {
					for (FireBall f : map[i][j]) {
						int mx = i + dx[f.d] * (f.s % N);
						int my = j + dy[f.d] * (f.s % N);

						if (mx >= N)
							mx -= N;
						else if (mx < 0)
							mx += N;

						if (my >= N)
							my -= N;
						else if (my < 0)
							my += N;

						tmp[mx][my].add(new FireBall(f.m, f.d, f.s));
					}
				}
			}
		}

		map = tmp;
		magic();
	}

	static void magic() {
		boolean isSame = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int size = map[i][j].size();
				int m = 0;
				int s = 0;
				int d = -1;
				if (size >= 2) {
					isSame = false;
					for (FireBall f : map[i][j]) {
						m += f.m;
						s += f.s;
						if (d == -1) {
							d = f.d;
						} else {
							if (d % 2 != f.d % 2)
								isSame = true;
						}
					}
					map[i][j].clear();
					if (isSame) {
						if(m / 5 > 0)
							for (int k = 0; k < 4; k++)
								map[i][j].add(new FireBall(m / 5, k * 2 + 1, s / size));
					} else {
						if(m / 5 > 0)
							for (int k = 0; k < 4; k++)
								map[i][j].add(new FireBall(m / 5, k * 2, s / size));
					}
				}
			}
		}
	}
}
