package jun.week3;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static boolean[][] check;
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		
		for(int i = 0 ; i <N ;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 1;
		for(int i = 1 ; i < 100; i++) {
			check = new boolean[N][N];
			int count = 0;
			rain(i);
			for(int r = 0; r < N ; r++) {
				for(int c = 0 ; c < N ; c++) {
					if(!visited[r][c] && !check[r][c]) {
						bfs(r, c);
						count++;
					}
				}
			}
			answer = Math.max(count, answer);
		}
		
		System.out.println(answer);
	}
	
	static void bfs(int r, int c) {
		check[r][c] = true;
		
		for(int i = 0 ; i < 4; i++) {
			int mr = r + dr[i];
			int mc = c + dc[i];
			if(mr < 0 || mc < 0 || mr >= N || mc >= N)
				continue;
			
			if(!visited[mr][mc] && !check[mr][mc]) {
				bfs(mr, mc);
			}
		}
	}
	static void rain(int height) {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(map[i][j] <= height)
					visited[i][j] = true;
			}
		}
	}
}
