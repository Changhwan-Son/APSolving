package jul.week2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14712_넴모넴모easy {

	static boolean[][] map;
	static int N, M, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new boolean[N][M];
		answer = 0;
		dfs(0, 0);

		System.out.println(answer);
	}

	static void dfs(int x, int y) {
		if (x == N - 1 && y == M) {
			answer++;
			return;
		}

		for (int i = x; i < N; i++) {
			for (int j = (i == x ? y : 0); j < M; j++) {
				if (i > 0 && j > 0 && map[i][j - 1] && map[i - 1][j] && map[i - 1][j - 1])
					continue;

				map[i][j] = true;
				dfs(i, j + 1);
				map[i][j] = false;
			}
		}
		answer++;
	}
}
