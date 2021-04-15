package apr.week2;

import java.io.*;
import java.util.*;

public class SWEA_1249_보급로 {

	static int[][] map;
	static int[][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int N, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			min = Integer.MAX_VALUE;
			visited = new int[N][N];

			for(int i = 0 ; i < N ; i++)
				Arrays.fill(visited[i], Integer.MAX_VALUE);

			String str = null;
			for (int i = 0; i < N; i++) {
				str = in.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			visited[0][0] = 0;
			
			bfs(0, 0);
			System.out.println("#" + t + " " + min);

		}
	}

	static void bfs(int x, int y) {
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return visited[o1[0]][o1[1]] - visited[o2[0]][o2[1]];
			}
		});
		q.offer(new int[] { x, y });

		while (!q.isEmpty()) {
			int cx = q.peek()[0];
			int cy = q.poll()[1];
			
			if(cx == N-1 && cy == N-1)
				min = Math.min(min, visited[N-1][N-1]);
			
			for (int i = 0; i < 4; i++) {
				int mx = cx + dx[i];
				int my = cy + dy[i];

				if(mx < 0 || mx >= N || my < 0 || my >= N )
					continue;
				
				if(visited[mx][my] > visited[cx][cy] + map[mx][my] || visited[mx][my] == Integer.MAX_VALUE) {
					visited[mx][my] = visited[cx][cy] + map[mx][my];
					q.offer(new int[] {mx, my});
				}
			}
		}
	}
}












