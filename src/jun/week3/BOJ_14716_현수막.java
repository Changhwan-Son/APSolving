package jun.week3;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14716_현수막 {

	static int M, N, count;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new boolean[M][N];
		count = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < M ; i++) {
			for(int j = 0 ; j < N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
					count++;
				}
			}
		}
		
		System.out.println(count);

	}

	static void bfs(int r, int c) {
		visited[r][c] = true;
		
		for(int i = 0 ; i < 8; i++) {
			int mr = r + dr[i];
			int mc = c + dc[i];
			if(mr < 0 || mc < 0 || mr >= M || mc >= N)
				continue;
			
			if(!visited[mr][mc] && map[mr][mc] == 1) {
				bfs(mr, mc);
			}
		}
	}
}
