package jun.week2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14499_주사위굴리기 {
	static int[][] map;
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };
	static int[] nums, dice;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		dice = new int[7];
		nums = new int[7];

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < K; i++) {
			int com = Integer.parseInt(st.nextToken());
			
			if (x+dx[com] < 0 || y+dy[com] < 0 || x+dx[com] >= N || y+dy[com] >= M) 
				continue;
			x += dx[com];
			y += dy[com];

			if (com == 3) {
				int tmp = dice[4];
				for (int j = 4; j > 1; j--)
					dice[j] = dice[j - 1];
				dice[1] = tmp;
			} else if (com == 4) {
				int tmp = dice[1];
				for (int j = 1; j < 4; j++)
					dice[j] = dice[j + 1];
				dice[4] = tmp;
			} else if (com == 1) {
				int tmp = dice[2];
				dice[2] = dice[6];
				dice[6] = dice[4];
				dice[4] = dice[5];
				dice[5] = tmp;
			} else if (com == 2) {
				int tmp = dice[2];
				dice[2] = dice[5];
				dice[5] = dice[4];
				dice[4] = dice[6];
				dice[6] = tmp;
			}

			if (map[x][y] == 0) {
				map[x][y] = dice[2];
			} else {
				dice[2] = map[x][y];
				map[x][y] = 0;
			}
			sb.append(dice[4]).append("\n");
		}
		System.out.println(sb);
	}
}
