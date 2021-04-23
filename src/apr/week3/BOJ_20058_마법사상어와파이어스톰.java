package apr.week3;

import java.io.*;
import java.util.*;

public class BOJ_20058_마법사상어와파이어스톰 {

	static int[][] map;
	static int[] level;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int N, Q;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
		Q = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		level = new int[Q];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < Q; i++) {
			rotate(Integer.parseInt(st.nextToken()));
			melt();
		}
		
		int sum = 0;
		int max = 0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += map[i][j];
				if(max <= map[i][j]) {
					if(max == map[i][j])
						cnt++;
					else
						cnt = 1;
					max = map[i][j];
				}
			}
		}
		System.out.println(sum);
		System.out.println(cnt);

	}

	static void rotate(int l) {
		int size = (int) Math.pow(2, l);

		for (int i = 0; i < N; i += N / size) {
			for (int j = 0; j < N; j += N / size) {
				int cnt = 0;
				ArrayList<Integer>[] list = new ArrayList[size];
				for (int x = i; x < i + size; x++) {
					ArrayList<Integer> tmp = new ArrayList<>();
					for (int y = j; y < j + size; y++) {
						tmp.add(map[x][y]);
					}
					list[cnt++] = new ArrayList<>(tmp);
				}

				cnt = 0;
				for(int y = j + N / size - 1; y >= j; y--) {
					int idx = 0;
					for(int x = i ; x < i + N / size; i++ ) {
						map[x][y] = list[cnt].get(idx++);
					}
					cnt++;
				}
			}
		}
	}

	static void melt() {
		int[][] tmp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = map[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int mx = i + dx[d];
					int my = j + dy[d];

					if (mx < 0 || my < 0 || mx >= N || my >= N)
						continue;
					if(map[mx][my] != 0)
						cnt++;
				}
				if(cnt < 3)
					tmp[i][j] = tmp[i][j] > 0 ? tmp[i][j] - 1 : 0;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp[i][j];
			}
		}
	}
}
