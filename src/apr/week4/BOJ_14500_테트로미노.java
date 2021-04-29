package apr.week4;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {

	static int N, M, max;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		max = 0;
		
		for(int i = 0; i < N;  i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < M ; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, map[i][j]);
				visited[i][j] = false;
				
				max = Math.max(max, getLastKind(i,j));
			}
		}
		
		System.out.println(max);
	}
	
	static int getLastKind(int r, int c) {
		int sum = map[r][c];
		int cnt = 0;
		int min = 1000;
		for(int i = 0 ; i < 4 ; i++) {
			int mr = r + dr[i];
			int mc = c + dc[i];
			
			if(cnt > 1)		// 상하좌우 중에 안되는 칸이 2개 이상이면
				return 0;
			
			if(mr < 0 || mc < 0 || mr >= N || mc >= M ) {
				cnt++;
				continue;
			}
			
			min = Math.min(min, map[mr][mc]);
			sum += map[mr][mc];
		}
		
		if(cnt == 0)
			sum -= min;
		
		return sum;
	}
	
	static void dfs(int r, int c, int cnt, int score) {
		if(cnt == 4) {
			max = Math.max(max, score);
			return;
		}
		
		for(int i =0 ; i < 4 ; i++) {
			int mr = r + dr[i];
			int mc = c + dc[i];
			
			if(mr < 0 || mc < 0 || mr >= N || mc >= M || visited[mr][mc])
				continue;
			
			visited[mr][mc] = true;
			dfs(mr, mc, cnt+1, score + map[mr][mc]);
			visited[mr][mc] = false;
		}
	}
}
