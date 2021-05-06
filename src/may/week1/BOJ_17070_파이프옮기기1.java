package may.week1;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17070_파이프옮기기1 {

	static int[][] map;
	static int[] dr = { 1, 1, 0 }; // 아래, 대각선, 오른쪽
	static int[] dc = { 0, 1, 1 };
	static int N, answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		answer = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 1, 0, 1);

		System.out.println(answer);
	}

	private static void dfs(int r, int c, int rm, int cm) {
		if (r == N - 1 && c == N - 1) {
			answer++;
			return;
		}

		if (rm == 1) {
			if (r + 1 < N && map[r + 1][c] != 1) {
				dfs(r + 1, c, 1, 0);
			}
		}
		
		if (cm == 1) {
			if (c + 1 < N && map[r][c + 1] != 1) {
				dfs(r, c + 1, 0, 1);
			}
		}

		for (int i = 0; i < 3; i++) {
			int mr = r + dr[i];
			int mc = c + dc[i];

			if (mr >= N || mc >= N || map[mr][mc] == 1) {
				return;
			}
		}

		dfs(r + 1, c + 1, 1, 1);

	}
}
