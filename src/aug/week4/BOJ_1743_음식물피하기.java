package aug.week4;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1743_음식물피하기 {

	static boolean[][] map;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int max, count, N, M, K;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		max = 0;
		
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r-1][c-1] = true;
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j]) {
					count = 0;
					map[i][j] = false;
					func(i, j);
				}
			}
		}
		
		System.out.println(max);
	}
	
	static void func(int r, int c) {
		count++;
		max = Math.max(count, max);
		
		for(int i = 0 ; i < 4 ; i++) {
			int mr = r + dr[i];
			int mc = c + dc[i];
			
			if(mr < 0 || mc < 0 || mr >= N || mc >= M)
				continue;
			
			if(!map[mr][mc])
				continue;
			
			map[mr][mc] = false;
			func(mr, mc);
		}
	}
}
