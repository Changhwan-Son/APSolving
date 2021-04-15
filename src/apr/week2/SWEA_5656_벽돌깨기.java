package apr.week2;

import java.io.*;
import java.util.*;

public class SWEA_5656_벽돌깨기 {

	static int N, W, H, min;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			int[][] map = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			go(0, map);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	static boolean go(int cnt, int[][] map) {
		int result = getRemain(map);
		if(result == 0) {
			min = 0;
			return true;
		}

		if (cnt == N) {
			min = Math.min(min, result);
			return false;
		}
		int[][] newMap = new int[H][W];
		for (int c = 0; c < W; c++) {
			int r = 0;
			while (r < H && map[r][c] == 0)
				r++;
			if (r == H) { 
				continue;
			} else {
				copy(map, newMap);
				boom(newMap, r, c);
				down(newMap);
				if(go(cnt + 1, newMap))
					return true;
			}
		}
		return false;
	}

	static int getRemain(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] > 0)
					cnt++;
			}
		}
		return cnt;
	}

	static void down(int[][] map) {
		Stack<Integer> stack = new Stack<>();
		for (int c = 0; c < W; c++) {
			for(int r = 0 ; r < H ; r++) {
				if(map[r][c] != 0)
					stack.push(map[r][c]);
			}
			
			for(int r = H - 1 ; r >= 0 ; r--) {
				if(stack.isEmpty())
					map[r][c] = 0;
				else
					map[r][c] = stack.pop();
			}
		}
	}

	static void boom(int[][] map, int r, int c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		if (map[r][c] > 1) {
			queue.offer(new int[] { r, c, map[r][c] });
		}
		map[r][c] = 0; 

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur[0];
				int nc = cur[1];
				for (int k = 1; k < cur[2]; k++) {
					nr += dr[d];
					nc += dc[d];
					if (nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == 0)
						continue;
					if (map[nr][nc] > 1) {
						queue.offer(new int[] { nr, nc, map[nr][nc] });
					}
					map[nr][nc] = 0;
				}
			}
		}
	}

	static void copy(int[][] map, int[][] newMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}
}
